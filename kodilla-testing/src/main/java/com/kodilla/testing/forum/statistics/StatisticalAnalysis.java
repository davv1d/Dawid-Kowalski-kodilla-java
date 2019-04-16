package com.kodilla.testing.forum.statistics;

public class StatisticalAnalysis {
    private int numberOfUsers;
    private int numberOFPosts;
    private int numberOfComments;
    private double avgNumberOfPostsPerUser;
    private double avgNumberOfCommentsPerUser;
    private double avgNumberOfCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.numberOfUsers = statistics.userNames().size();
        this.numberOFPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();
        this.avgNumberOfPostsPerUser = this.calculateAvgNumberOfPostsPerUser(statistics);
        this.avgNumberOfCommentsPerUser = this.calculateAvgNumberOfCommentsPerUser(statistics);
        this.avgNumberOfCommentsPerPost = this.calculateAvgNumberOfCommentsPerPost(statistics);
    }

    private double calculateAvgNumberOfPostsPerUser(Statistics statistics) {
        double result = -1;
        if (statistics.userNames().size() != 0) {
            result = (double) statistics.postsCount() / statistics.userNames().size();
        }
        return result;
    }

    private double calculateAvgNumberOfCommentsPerUser(Statistics statistics) {
        double result = -1;
        if (statistics.userNames().size() != 0) {
            result = (double) statistics.commentsCount() / statistics.userNames().size();
        }
        return result;
    }

    private double calculateAvgNumberOfCommentsPerPost(Statistics statistics) {
        double result = -1;
        if (statistics.postsCount() != 0) {
            result = (double) statistics.commentsCount() / statistics.postsCount();
        }
        return result;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOFPosts() {
        return numberOFPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAvgNumberOfPostsPerUser() {
        return avgNumberOfPostsPerUser;
    }

    public double getAvgNumberOfCommentsPerUser() {
        return avgNumberOfCommentsPerUser;
    }

    public double getAvgNumberOfCommentsPerPost() {
        return avgNumberOfCommentsPerPost;
    }
}
