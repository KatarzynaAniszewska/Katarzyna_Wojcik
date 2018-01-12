package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString(){
        //given
        //creating the TaskList for todos
        TasksList listToDo = new TasksList("To do Tasks");

        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n->listToDo.getTasks().add(new Task("To Do Task number "+n)));
        //creating the TaskList for in progress
        TasksList listInProgress = new TasksList("In progress Tasks");

        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n->listInProgress.getTasks().add(new Task("n progress Task number "+n)));

        //creating the TaskList for done
        TasksList listDone = new TasksList("Done Tasks");

        IntStream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n->listDone.getTasks().add(new Task("Done Task number "+n)));

        //creating the Board and assigning the list
        Board board = new Board("Project number ");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        //making a shallow copy
        Board clonedBoard=null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2 ");
        } catch (CloneNotSupportedException e){
            System.out.println(e);

        }

        //making a deep copy
        Board deepClonedBoard = null;
        try{
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        Assert.assertEquals(3, board.getLists().size());
        Assert.assertEquals(3, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
        ;

    }
}
