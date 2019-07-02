package com.kodilla.hibernate.taskList.dao;

import com.kodilla.hibernate.taskList.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

}
