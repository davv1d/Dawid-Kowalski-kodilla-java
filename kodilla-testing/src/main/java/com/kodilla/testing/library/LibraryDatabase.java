package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
    public List<Book> listBooksWithCondition(String titleFragment);

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser);

    public boolean rentABook(LibraryUser libraryUser, Book book);

    public int returnBooks(LibraryUser libraryUser);
}
