package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class TasksList {
    final String name;

    public TasksList(String name) {
        this.name = name;
    }

    final List<Task>tasks= new ArrayList<>();

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        String s = "   List [" + name + "]";
        for(Task task : tasks) {
            s = s + "\n" + task.toString();
        }
        return s;
    }


    public List<Task> getTasks() {
        return tasks;
    }
}
