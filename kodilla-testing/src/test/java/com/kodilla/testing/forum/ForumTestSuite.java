package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.Assert;
import org.junit.Test;

public class ForumTestSuite {
    @Test
    public void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("John");
        //When
        String result = simpleUser.getUsername();
        //Then
        Assert.assertEquals("John", result);
    }
}
