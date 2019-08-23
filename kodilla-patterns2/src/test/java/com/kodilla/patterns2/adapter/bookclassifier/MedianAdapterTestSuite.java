package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedianTest() {
        //Given
        MedianAdapter adapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("author 1", "title 1", 1950, "sig 1"));
        bookSet.add(new Book("author 2", "title 2", 1960, "sig 2"));
        bookSet.add(new Book("author 3", "title 3", 1970, "sig 3"));
        bookSet.add(new Book("author 4", "title 4", 1980, "sig 4"));
        bookSet.add(new Book("author 5", "title 5", 1990, "sig 5"));
        //When
        int yearMedian = adapter.publicationYearMedian(bookSet);
        //Then
        System.out.println(yearMedian);
        Assert.assertEquals(1970, yearMedian);
    }
}
