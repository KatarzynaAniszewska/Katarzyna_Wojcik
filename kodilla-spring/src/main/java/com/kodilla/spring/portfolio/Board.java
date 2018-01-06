package com.kodilla.spring.portfolio;



public class Board{
    TaskList toDoLIst;
    TaskList inProgressList;
    TaskList doneList;

    public Board(TaskList toDoLIst, TaskList inProgressList, TaskList doneList) {
        this.toDoLIst = toDoLIst;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoLIst() {
        return toDoLIst;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    @Override
    public String toString() {
        return "Board{" +
                "toDoLIst=" + toDoLIst +
                ", inProgressList=" + inProgressList +
                ", doneList=" + doneList +
                '}';
    }
}
