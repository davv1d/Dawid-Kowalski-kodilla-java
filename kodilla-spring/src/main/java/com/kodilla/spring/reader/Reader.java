package com.kodilla.spring.reader;

public final class Reader {
    private final Book book;


    public Reader(final Book book) {
        this.book = book;
    }

    public void read() {
        System.out.println("Reading: " + book.getTitle());
    }
}
