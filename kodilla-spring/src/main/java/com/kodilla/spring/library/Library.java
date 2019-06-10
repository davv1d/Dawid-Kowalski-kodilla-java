package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library() {
        //do nothing
    }

    @Autowired
    public Library(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
