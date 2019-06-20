package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);
        boolean isTaskExecuted = task.isTaskExecuted();
        task.executeTask();
        //Then
        Assert.assertEquals("Shopping", task.getName());
        Assert.assertFalse(isTaskExecuted);
        Assert.assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.PAINTING_TASK);
        boolean isTaskExecute = task.isTaskExecuted();
        task.executeTask();
        //Then
        Assert.assertEquals("Paint", task.getName());
        Assert.assertFalse(isTaskExecute);
        Assert.assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.makeTask(TaskFactory.DRIVING_TASK);
        boolean isTaskExecuted = task.isTaskExecuted();
        task.executeTask();
        //Then
        Assert.assertEquals("Drive", task.getName());
        Assert.assertFalse(isTaskExecuted);
        Assert.assertTrue(task.isTaskExecuted());
    }
}
