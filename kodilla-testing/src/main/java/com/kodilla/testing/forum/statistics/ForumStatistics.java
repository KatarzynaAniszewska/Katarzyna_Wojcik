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

            if (statistics.usersNames().size()>0) {
                double a = statistics.postsCount() / statistics.usersNames().size();
                postsAveragePerUser = Math.floor(a * 100) / 100;
            } else {postsAveragePerUser=0;}

        if (statistics.usersNames().size()>0) {
        double b = (double) statistics.commentsCount() /  statistics.usersNames().size();
            commentsAveragePerUser= Math.floor(b*100)/100;
        } else {commentsAveragePerUser=0;}

        if (statistics.postsCount()>0){
            double c = (double) statistics.commentsCount() / (double) statistics.postsCount();
            commentsAveragePerPost= Math.floor(c*100)/100;
        } else {commentsAveragePerPost=0;}


        }
    }





