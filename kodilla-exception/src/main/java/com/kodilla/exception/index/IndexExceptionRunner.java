package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {
    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();

        if(collection.size() > 1) {
            String movie = collection.get(0);
            System.out.println(movie);

            String anotherMovie = collection.get(1);
            System.out.println(anotherMovie);
        }
    }
}
