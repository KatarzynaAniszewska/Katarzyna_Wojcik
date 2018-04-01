package com.kodilla.patterns2.observer.homework;

public class Mentor implements ObseverMentor {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }
    @Override
    public void update(Homework homework) {
        System.out.println( mentorName + " : new unchecked tasks " + homework.getName() + "\n" +
        " total: " +homework.getHomeworks().size());
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
