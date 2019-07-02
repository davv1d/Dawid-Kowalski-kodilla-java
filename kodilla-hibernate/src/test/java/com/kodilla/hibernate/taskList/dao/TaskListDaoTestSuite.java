package com.kodilla.hibernate.taskList.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.taskList.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LIST_NAME = "Test; List Name";
    private static final String DESCRIPTION = "Test: Description";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();
        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);
        //Then
        Assert.assertEquals(1, readTaskLists.size());
        //CleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LIST_NAME, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        task1.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        taskListDao.deleteById(id);
    }

}
