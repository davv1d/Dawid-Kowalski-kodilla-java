package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsAnalysisTestSuite {

    @Test
    public void testCalNumOfPostsPerUserWhenNonPosts() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfPosts = 0;
        List<String> usersList = Arrays.asList("A", "B", "C", "D");
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postsCount()).thenReturn(numberOfPosts);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, statisticalAnalysis.getAvgNumberOfPostsPerUser(), 0);
    }

    @Test
    public void testCalNumOfPostsPerUserWhenNonUsers() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfPosts = 10;
        List<String> usersList = Arrays.asList();
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postsCount()).thenReturn(numberOfPosts);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(-1, statisticalAnalysis.getAvgNumberOfPostsPerUser(), 0);
    }

    @Test
    public void testCalNumOfPostsPerUser() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfPosts = 1000;
        List<String> usersList = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            usersList.add(Integer.toString(i));
        }
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postsCount()).thenReturn(numberOfPosts);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(10, statisticalAnalysis.getAvgNumberOfPostsPerUser(), 0);
    }

    @Test
    public void testCalNumOfCommentsPerUserWhenNonComments() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfComments = 0;
        List<String> usersList = Arrays.asList("A", "B");
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(numberOfComments);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, statisticalAnalysis.getAvgNumberOfCommentsPerUser(), 0);
    }

    @Test
    public void testCalNumOfCommentsPerUserWhenNonUsers() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfComments = 10;
        List<String> usersList = Arrays.asList();
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(numberOfComments);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(-1, statisticalAnalysis.getAvgNumberOfCommentsPerUser(), 0);
    }

    @Test
    public void testCalNumOfCommentsPerUser() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfComments = 10;
        List<String> usersList = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            usersList.add(Integer.toString(i));
        }
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(numberOfComments);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0.1, statisticalAnalysis.getAvgNumberOfCommentsPerUser(), 0);
    }

    @Test
    public void testCalNumOfCommentsPerPostWhenNonPosts() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfComments = 100;
        int numberOfPosts = 0;
        when(statistics.postsCount()).thenReturn(numberOfPosts);
        when(statistics.commentsCount()).thenReturn(numberOfComments);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(-1, statisticalAnalysis.getAvgNumberOfCommentsPerPost(), 0);
    }

    @Test
    public void testCalNumOfCommentsPerPostWhenNonComments() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfComments = 0;
        int numberOfPosts = 1000;
        when(statistics.postsCount()).thenReturn(numberOfPosts);
        when(statistics.commentsCount()).thenReturn(numberOfComments);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, statisticalAnalysis.getAvgNumberOfCommentsPerPost(), 0);
    }

    @Test
    public void testCalNumOfCommentsPerPostWhenMorePosts() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfComments = 100;
        int numberOfPosts = 1000;
        when(statistics.postsCount()).thenReturn(numberOfPosts);
        when(statistics.commentsCount()).thenReturn(numberOfComments);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0.1, statisticalAnalysis.getAvgNumberOfCommentsPerPost(), 0);
    }

    @Test
    public void testCalNumOfCommentsPerPostWhenMoreComments() {
        //Given
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis();
        Statistics statistics = mock(Statistics.class);
        int numberOfComments = 1000;
        int numberOfPosts = 100;
        when(statistics.postsCount()).thenReturn(numberOfPosts);
        when(statistics.commentsCount()).thenReturn(numberOfComments);
        //When
        statisticalAnalysis.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(10, statisticalAnalysis.getAvgNumberOfCommentsPerPost(), 0);
    }


}
