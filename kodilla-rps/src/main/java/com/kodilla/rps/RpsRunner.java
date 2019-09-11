package com.kodilla.rps;

import com.kodilla.rps.computer.Computer;
import com.kodilla.rps.elements.Element;
import com.kodilla.rps.elements.ElementCreateException;
import com.kodilla.rps.elements.ElementName;
import com.kodilla.rps.elements.ElementsFactory;
import com.kodilla.rps.judge.Judge;
import com.kodilla.rps.view.ConsoleValidator;
import com.kodilla.rps.view.Drawer;

import java.io.InputStreamReader;
import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
//        System.out.println(scanner.next());
        String end = "";
        while (!end.equals("x")) {
            while (end.equals("n")){
                System.out.println(end);
                end = ConsoleValidator.validMenuVaues(scanner.next());
            }
            end = ConsoleValidator.validMenuVaues(scanner.next());
        }
    }
}
