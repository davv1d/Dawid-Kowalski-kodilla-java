package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        int[] numbers = {5, 5, 5, 2, 4, 6, 4, 8, 6, 8, 8, 6, 1, 4, 6, 8, 13, 95, 5456, 48};
        //When
        double resultAverage = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(284.9, resultAverage, 0);
    }
}
