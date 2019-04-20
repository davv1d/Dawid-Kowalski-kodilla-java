package com.kodilla.stream.portfolio;

import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BoardTestSuite {
    public Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");
        //tasks
        Task task1 = new Task("Microservice for taking temperature", "Write and test the microservice taking\n" +
                "the temperature from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refctor compny logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    public void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assert.assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTask() {
        //Given
        Board project = prepareTestData();
        User user1 = new User("developer1", "John Smith");
        //When
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getAssignedUser().equals(user1))
                .collect(Collectors.toList());
        //Then
        Assert.assertEquals(2, tasks.size());
        Assert.assertEquals(user1, tasks.get(0).getAssignedUser());
        Assert.assertEquals(user1, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
        //Then
        Assert.assertEquals(1, tasks.size());
        Assert.assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();
        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .map(task -> task.getCreated())
                .filter(localDate -> localDate.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();
        //Then
        Assert.assertEquals(2, longTasks);
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask() {
        //Given
        Board project = prepareTestData();
        //When
        TaskList inProgressTask = new TaskList("In progress");
        //version 1. sum/count
        long numberOfWorkingDays = project.getTaskLists().stream()
                .filter(inProgressTask::equals)
                .flatMap(taskList -> taskList.getTasks().stream())
                .map(task -> task.getCreated().until(LocalDate.now(), ChronoUnit.DAYS))
                .reduce(0L, (sum, current) -> sum = sum + current);
        long numberOfTasks = project.getTaskLists().stream()
                .filter(inProgressTask::equals)
                .flatMap(taskList -> taskList.getTasks().stream())
                .count();
        double calculatedAverage = (double) numberOfWorkingDays / numberOfTasks;
        //version 2. average
        List<TaskList> taskLists = project.getTaskLists();
        OptionalDouble optionalDouble1 = IntStream.range(0, project.getTaskLists().size())
                .filter(n -> taskLists.get(n).equals(inProgressTask))
                .flatMap(n -> IntStream.range(0, taskLists.get(n).getTasks().size())
                        .map(k -> Period.between(taskLists.get(n).getTasks().get(k).getCreated(), LocalDate.now()).getDays()))
                .average();

        OptionalDouble optionalDouble2 = IntStream.range(0, project.getTaskLists().size())
                .filter(n -> taskLists.get(n).equals(inProgressTask))
                .flatMap(n -> IntStream.range(0, taskLists.get(n).getTasks().size())
                        .map(k -> {
                            TaskList taskList = taskLists.get(n);
                            Task task = taskList.getTasks().get(k);
                            int days = Period.between(task.getCreated(), LocalDate.now()).getDays();
                            return days;
                        }))
                .average();
        double average = optionalDouble2.isPresent() ? optionalDouble2.getAsDouble() : -1;
        //Then
        Assert.assertEquals(10, calculatedAverage, 0.0001);
        Assert.assertEquals(10, average, 0.0001);
    }
}
