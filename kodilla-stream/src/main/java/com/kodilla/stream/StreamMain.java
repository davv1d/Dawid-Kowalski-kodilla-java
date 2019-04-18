package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Example text 1", text -> text.toUpperCase());
        poemBeautifier.beautify("Example text 2", text -> "ABC " + text + " ABC");
        poemBeautifier.beautify("This will be strange text", text -> {
            StringBuilder sBuilder = new StringBuilder();
            char[] charArray = text.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0) {
                    sBuilder.append(Character.toString(charArray[i]).toUpperCase());
                } else {
                    sBuilder.append(charArray[i]);
                }
            }
            return sBuilder.toString();
        });
        poemBeautifier.beautify("Palindrome", text -> {
            text = text.toLowerCase();
            StringBuilder sBuilder = new StringBuilder();
            char[] charArray = text.toCharArray();
            for (int i = charArray.length - 1; i >= 0; i--)
                sBuilder.append(charArray[i]);
            return sBuilder.toString();
        });

        System.out.println("Using stream to generate numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
