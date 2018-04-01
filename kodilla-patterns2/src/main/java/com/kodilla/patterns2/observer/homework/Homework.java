package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Homework implements ObservableHomeworks {
    private final Deque<String>homeworks;
    private final List<ObseverMentor>mentors;
    private final String name;

    public Homework(String name) {
        this.homeworks = new ArrayDeque<>();
        this.mentors = new ArrayList<>();
        this.name = name;
    }
    @Override
    public void registerObserver(ObseverMentor obseverMentor) {
        mentors.add(obseverMentor);
    }
    @Override
    public void notifytObserver() {
        for (ObseverMentor obseverMentor : mentors){
            obseverMentor.update(this);
        }
    }
    @Override
    public void removeObserver(ObseverMentor obseverMentor) {
        mentors.remove(obseverMentor);
    }
    public void addHomework(String task) {
        homeworks.add(task);
        notifytObserver();
    }

    public Deque<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }
}
