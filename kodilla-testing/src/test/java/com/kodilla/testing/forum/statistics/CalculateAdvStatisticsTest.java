package com.kodilla.testing.forum.statistics;


import org.junit.*;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateAdvStatisticsTest {


    private static int testCounter = 0;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    Statistics statisticsMock = mock(Statistics.class);
    ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
    List<String> userNames = new ArrayList<>();

    @Test
    //liczba postów = 0
    public void testCaseAvaragesCalculationsNoPostsAdded() {

        // Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userNames = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(userNames);
        userNames.add("aaaa");
        when(statisticsMock.postsCount()).thenReturn(1);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1000.0, forumStatistics.commentsAveragePerUser,0);
        Assert.assertEquals(1.0, forumStatistics.postsAveragePerUser,0);
        Assert.assertEquals(1000.0, forumStatistics.commentsAveragePerPost,0);
    }

    @Test
//gdy liczba postów = 1000
    public void testCaseAvaragesCalculations1000PostsAdded() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(userNames);
        userNames.add("aaaa");
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        //When
       forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1000.0, forumStatistics.commentsAveragePerUser,0);
        Assert.assertEquals(1000.0, forumStatistics.postsAveragePerUser,0);
        Assert.assertEquals(1.0, forumStatistics.commentsAveragePerPost,0);
    }

    @Test
    //gdy liczba komentarzy = 0
    public void testCaseAvaragesCalculationsNoCommemtsAdded() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(userNames);
        userNames.add("aaaa");
        when(statisticsMock.postsCount()).thenReturn(500);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0.0, forumStatistics.commentsAveragePerUser,0);
        Assert.assertEquals(500.0, forumStatistics.postsAveragePerUser,0);
        Assert.assertEquals(0.0, forumStatistics.commentsAveragePerPost,0);
    }

    @Test
    //gdy liczba komentarzy < liczba postów
    public void testCaseAvaragesCalculationsLessCommentsThenPosts() {

        // Given
        when(statisticsMock.usersNames()).thenReturn(userNames);
        userNames.add("aaaa");
        when(statisticsMock.postsCount()).thenReturn(200);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(100.0, forumStatistics.commentsAveragePerUser,0);
        Assert.assertEquals(200.0, forumStatistics.postsAveragePerUser,0);
        Assert.assertEquals(0.5, forumStatistics.commentsAveragePerPost,0.0);
    }

    @Test

    //gdy liczba komentarzy > liczba postów
    public void testCaseAveragesCalculationsMoreCommentsThenPosts() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(userNames);
        userNames.add("aaaa");
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(300);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(300.0, forumStatistics.commentsAveragePerUser,0);
        Assert.assertEquals(100.0, forumStatistics.postsAveragePerUser,0);
        Assert.assertEquals(3.0, forumStatistics.commentsAveragePerPost,0.0);
    }



    @Test

    //gdy liczba użytkowników = 0 Ten test pokazuje błąd
    public void testCaseAvaragesCalculationsNoUsers() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(userNames);

        when(statisticsMock.postsCount()).thenReturn(300);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(0.0, forumStatistics.commentsAveragePerUser,0);
        Assert.assertEquals(0.0, forumStatistics.postsAveragePerUser,0);
        Assert.assertEquals(0.33, forumStatistics.commentsAveragePerPost,0);;
    }



    @Test

    //gdy liczba użytkowników = 100
    public void testCaseAvaragesCalculations100users() {
        // Given
        when(statisticsMock.usersNames()).thenReturn(userNames);
        Random rand = new Random();
        int x = rand.nextInt(10);
        StringBuilder stringBuilder = new StringBuilder();
        for (int n =0;n<100;n++){
            for(int i=0;i<x;i++){
                stringBuilder.append('a');
            }
            userNames.add(stringBuilder.toString());
        }
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        Assert.assertEquals(1.0, forumStatistics.commentsAveragePerUser,0);
        Assert.assertEquals(1.0, forumStatistics.postsAveragePerUser,0);
        Assert.assertEquals(1.0, forumStatistics.commentsAveragePerPost,0.0);

    }
}