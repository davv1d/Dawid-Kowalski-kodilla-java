package com.kodilla.sudoku.division;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SectorsTestSuite {
    @Test
    public void testGet() {
        //Given
        int value1 = 2;
        int value2 = 3;
        int value3 = 6;
        List<Integer> expected1 = Arrays.asList(0,1,2);
        List<Integer> expected2 = Arrays.asList(3,4,5);
        List<Integer> expected3 = Arrays.asList(6,7,8);
        //When
        List<Integer> result1 = Sectors.get(value1);
        List<Integer> result2 = Sectors.get(value2);
        List<Integer> result3 = Sectors.get(value3);
        //Then
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
        Assert.assertEquals(expected3, result3);


    }
}
