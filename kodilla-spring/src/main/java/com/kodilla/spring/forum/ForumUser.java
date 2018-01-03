package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser {
    String userName;

    public ForumUser() {
        this("John Smith");
    }

    public ForumUser(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
