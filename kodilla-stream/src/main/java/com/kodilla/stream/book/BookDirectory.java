package com.kodilla.stream.book;

import java.util.ArrayList;
import java.util.List;

public class BookDirectory {
    private final List<Book> theBookList = new ArrayList<>();

    public BookDirectory() {
        theBookList.add(new Book("Dylan Murphy", "Wolf of the mountains", 2003, "0001"));
        theBookList.add(new Book("Phoebe Pearson", "Slaves of dream", 2012, "0002"));
        theBookList.add(new Book("Morgan Walsh", "Obliteration of heaven", 2001, "0003"));
        theBookList.add(new Book("Aime Murphy", "Rejecting the night", 2015, "0004"));
        theBookList.add(new Book("Ryan Talley", "Gangsters and knigs", 2007, "0005"));
        theBookList.add(new Book("Madelynn Carson", "Unity without duty", 2007, "0006"));
        theBookList.add(new Book("Giancarlo Guerrero", "Enemies of eternity", 2009, "0007"));
    }

    public List<Book> getList() {
        return new ArrayList<>(theBookList);
    }
}
