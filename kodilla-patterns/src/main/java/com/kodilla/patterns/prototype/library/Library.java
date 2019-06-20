package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Library extends Prototype {
     private String name;
     private Set<Book> books = new LinkedHashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + "\'" +
                ", books=\n" + books +
                '}';
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
       Library cloneLibrary = (Library) super.clone();
       cloneLibrary.books = new LinkedHashSet<>();
        for (Book book: this.books) {
            cloneLibrary.getBooks().add(book);
        }
        return cloneLibrary;
    }
}
