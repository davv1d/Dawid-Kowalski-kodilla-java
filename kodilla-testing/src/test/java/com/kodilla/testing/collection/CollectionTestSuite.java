package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        OddNumbersExterminator oddNumEx = new OddNumbersExterminator();
        //When
        System.out.println("Test empty list");
        ArrayList<Integer> result = oddNumEx.exterminator(emptyList);
        //Then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> normalList = new ArrayList<Integer>();
        normalList.add(1);
        normalList.add(3);
        normalList.add(4);
        normalList.add(8);
        normalList.add(6);
        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        expectedList.add(4);
        expectedList.add(8);
        expectedList.add(6);
        //Then
        System.out.println("Test normal list");
        ArrayList<Integer> result = oddNumbersExterminator.exterminator(normalList);
        //When
        Assert.assertEquals(expectedList, result);
    }
}
