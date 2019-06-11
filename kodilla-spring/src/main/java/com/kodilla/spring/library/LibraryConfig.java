package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {
    @Bean
    public Library createLibrary() {
        return new Library(createLibraryDbController());
    }

    @Bean
    public LibraryDbController createLibraryDbController() {
        return new LibraryDbController();
    }
}
