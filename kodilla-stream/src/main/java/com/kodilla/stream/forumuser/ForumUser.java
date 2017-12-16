package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String userName;
    private final char userSex;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(final int userID, final String userName, final char userSex, final int yearOfBirth,
                     final int monthOfBirth,final int dayOfBirth,  int numberOfPosts) {
        this.userID = userID;
        this.userName = userName;
        this.userSex = userSex;
        this.dateOfBirth = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public int getNumberOfPosts() {
        return numberOfPosts;


    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }

}


