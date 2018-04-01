package com.kodilla.patterns2.observer.forum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ForumUserTestSuite {
    @Test
    public void testUpdate(){
        //Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolForum = new JavaToolsForumTopic();
        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar = new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");
        javaHelpForum.registerObserver(johnSmith);
        javaToolForum.registerObserver(ivoneEscobar);
        javaHelpForum.registerObserver(jessiePinkman);
        javaToolForum.registerObserver(jessiePinkman);
        //When
        javaHelpForum.addPost("Hi everyone");
        javaHelpForum.addPost("Better try");
        javaToolForum.addPost("Help pls");
        javaHelpForum.addPost("Why while ?");
        javaToolForum.addPost("When I try");
        //Then
        assertEquals(3,johnSmith.getUpdateCount());
        assertEquals(3,ivoneEscobar.getUpdateCount());
        assertEquals(3,jessiePinkman.getUpdateCount());
    }
}
