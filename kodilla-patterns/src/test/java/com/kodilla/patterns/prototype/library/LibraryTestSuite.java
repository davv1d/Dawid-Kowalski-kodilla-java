package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        List<Book> tempList = new ArrayList<>();
        Library library = new Library("Library 1");
        IntStream.iterate(1, n-> n+1)
                .limit(10)
                .forEach(n -> tempList.add(new Book("Title " + n, "Author " + n, LocalDate.now().plusDays(n))));
        library.getBooks().addAll(tempList);

        //making a swallow copy of object library
        Library shallowLibrary = null;
        try {
            shallowLibrary = library.shallowCopy();
            shallowLibrary.setName("Shallow library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //making a deep copy of object library
        Library deepLibrary = null;
        try {
            deepLibrary = library.deepCopy();
            deepLibrary.setName("Deep library");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //When
        IntStream.iterate(0, n-> n+1)
                .limit(5)
                .forEach(n-> library.getBooks().remove(tempList.get(n)));

        //Then
        System.out.println(library);
        System.out.println(shallowLibrary);
        System.out.println(deepLibrary);
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, shallowLibrary.getBooks().size());
        Assert.assertEquals(10, deepLibrary.getBooks().size());
        Assert.assertEquals( shallowLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepLibrary.getBooks(), library.getBooks());

    }
}

