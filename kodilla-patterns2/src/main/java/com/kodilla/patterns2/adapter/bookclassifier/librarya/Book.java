package com.kodilla.patterns2.adapter.bookclassifier.librarya;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    public Book(String author, String title, int publicationYear, String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (getPublicationYear() != book.getPublicationYear()) return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        if (getTitle() != null ? !getTitle().equals(book.getTitle()) : book.getTitle() != null) return false;
        return getSignature() != null ? getSignature().equals(book.getSignature()) : book.getSignature() == null;

    }

    @Override
    public int hashCode() {
        int result = getAuthor() != null ? getAuthor().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getPublicationYear();
        result = 31 * result + (getSignature() != null ? getSignature().hashCode() : 0);
        return result;
    }

}
