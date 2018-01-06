package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BoardConfig {
    @Bean
    public Board getBoard() {
        return new Board(getTaskListOne(),getTaskListTwo(),getTaskListThree());
    }

    @Bean("TaskList1")
    @Scope("prototype")
    public TaskList getTaskListOne() {
        return new TaskList();

    }

    @Bean("TaskList2")
    @Scope("prototype")
    public TaskList getTaskListTwo() {
        return new TaskList();
    }

    @Bean("TaskList3")
    @Scope("prototype")
    public TaskList getTaskListThree() {
        return new TaskList();


    }
}