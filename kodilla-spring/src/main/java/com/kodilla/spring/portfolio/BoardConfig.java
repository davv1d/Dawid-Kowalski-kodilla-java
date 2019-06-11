package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Autowired
    TaskList toDoTasks;

    @Autowired
    TaskList inProgressTasks;

    @Autowired
    TaskList doneTasks;

    @Bean
    public Board createBoard() {
        return new Board(toDoTasks, inProgressTasks, doneTasks);
    }

    @Bean
    @Scope("prototype")
    public TaskList createTaskList() {
        return new TaskList();
    }
}
