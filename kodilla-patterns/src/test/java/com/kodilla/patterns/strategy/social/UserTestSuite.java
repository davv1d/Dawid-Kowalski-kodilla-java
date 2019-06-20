package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User john = new Millenials("John");
        User tony = new YGenerations("Tony");
        User frank = new ZGeneration("Frank");
        //When
        String johnSharePost = john.sharePost();
        System.out.println("John share: " + johnSharePost);
        String tonySharePost = tony.sharePost();
        System.out.println("Tony share: " + tonySharePost);
        String frankSharePost = frank.sharePost();
        System.out.println("Frank share: " + frankSharePost);
        //Then
        Assert.assertEquals("You used facebook", johnSharePost);
        Assert.assertEquals("You used twitter", tonySharePost);
        Assert.assertEquals("You used snapchat", frankSharePost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User john = new Millenials("John");
        //When
        String johnSharePost = john.sharePost();
        System.out.println("John share: " + johnSharePost);
        john.setSocialPublisher(new TwitterPublisher());
        johnSharePost = john.sharePost();
        System.out.println("John now share: " + johnSharePost);
        //Then
        Assert.assertEquals("You used twitter", johnSharePost);
    }
}
