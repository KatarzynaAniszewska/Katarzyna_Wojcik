package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BoardTestSuite {

    @Test
    public void testAddTask(){

        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);

        //When
        TaskList taskList1 = (TaskList)context.getBean("TaskList1");
        TaskList taskList2 = (TaskList)context.getBean("TaskList2");
        TaskList taskList3 = (TaskList)context.getBean("TaskList3");
        boolean taskListExist = context.containsBean("TaskList1");
        Board board1 = (Board) context.getBean("getBoard");
        boolean board1Exists = context.containsBean("getBoard");


        board1.getToDoLIst().getTasks().add("===Example To do===");
        board1.getInProgressList().getTasks().add("===Example In prpogress===");
        board1.getDoneList().getTasks().add("===Example done===");



        //Then
        System.out.println(board1);

        Assert.assertEquals("===Example To do===",board1.getToDoLIst().getTasks().get(0));
        Assert.assertEquals("===Example In prpogress===",board1.getInProgressList().getTasks().get(0));
        Assert.assertEquals("===Example done===",board1.getDoneList().getTasks().get(0));
    }
}
