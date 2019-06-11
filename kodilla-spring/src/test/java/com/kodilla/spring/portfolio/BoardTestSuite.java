package com.kodilla.spring.portfolio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.addTaskToToDoList("to do task number 1");
        board.addTaskToInProgressList("in progress task number 1");
        board.addTaskToDoneList("done task number 1");
        //When & Then
        System.out.println("To do list >>");
        board.getToDoList().printTasks();
        System.out.println("<<");
        System.out.println("In progress list >>");
        board.getInProgressList().printTasks();
        System.out.println("<<");
        System.out.println("Done list >>");
        board.getDoneList().printTasks();
        System.out.println("<<");
    }
}
