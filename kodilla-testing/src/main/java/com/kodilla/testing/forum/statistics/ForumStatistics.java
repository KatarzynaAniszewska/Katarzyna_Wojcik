package com.kodilla.testing.forum.statistics;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ForumStatistics {
    Statistics statistics;
    int numberOfusers;
    double postsAveragePerUser;
    double commentsAveragePerUser;
    double commentsAveragePerPost;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }


    public double getPostsAveragePerUser() {
        return postsAveragePerUser;
    }

    public double getCommentsAveragePerUser() {
        return commentsAveragePerUser;
    }

    public double getCommentsAveragePerPost() {
        return commentsAveragePerPost;
    }

    public void ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        try {

            double a = statistics.postsCount() / (double) statistics.usersNames().size();
            postsAveragePerUser =Math.floor(a*100)/100;

            double b = (double) statistics.commentsCount() / (double) statistics.usersNames().size();
            commentsAveragePerUser= Math.floor(b*100)/100;

            double c = (double) statistics.commentsCount() / (double) statistics.postsCount();
            commentsAveragePerPost= Math.floor(c*100)/100;

        } catch (ArithmeticException e){
            System.out.println("arthmetic exception");

             postsAveragePerUser =0;
             commentsAveragePerUser=0;
             commentsAveragePerPost=0;



        }
    }
}




