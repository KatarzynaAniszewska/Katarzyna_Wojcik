package com.kodilla.stream;



import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultMaptOfForumUsers = forum.getList().stream()
                .filter(forumUser -> forumUser.getUserSex() == 'm')
                .filter(forumUser -> forumUser.getDateOfBirth().getYear() <= 1997)
                .filter(forumUser -> forumUser.getNumberOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        theResultMaptOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + "- " + entry.getValue())
                .forEach(System.out::println);
    }
}






