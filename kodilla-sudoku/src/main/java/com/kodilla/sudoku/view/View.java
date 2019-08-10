package com.kodilla.sudoku.view;

import com.kodilla.sudoku.model.board.EmptyBoard;
import com.kodilla.sudoku.model.board.SudokuBoard;
import com.kodilla.sudoku.model.board.element.Position;
import com.kodilla.sudoku.model.board.element.SudokuElement;
import com.kodilla.sudoku.model.dto.Tuple;
import com.kodilla.sudoku.view.validate.ConsoleValidator;

import java.io.InputStreamReader;
import java.util.Scanner;

public class View {

    public static Tuple<SudokuBoard, String> writeMenu() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Sudoku Gsme");
        System.out.println("Start game? yes[y]/exit[e]");
        String end = "";
        while (!end.equals("y")) {
            end = scanner.next();
            if (end.equals("e")) System.exit(0);
        }
        SudokuBoard board = new EmptyBoard().getBoard();
        System.out.println(board);
        while (!end.equals("e") && !end.equals("SUDOKU")) {
            int row = getValuesLoop(scanner, "Please enter number of row: ") - 1;
            int column = getValuesLoop(scanner, "Please enter number of column: ") - 1;
            int value = getValuesLoop(scanner, "Please enter value: ");
            board.getSudokuRows().get(row).getElements().set(column, new SudokuElement(value, new Position(row, column)));
            System.out.println(board);
            System.out.println("[c] clear board,[e] exit, [SUDOKU] solve sudoku, other letter continue write");
            end = scanner.next();
            if (end.equals("c")) board = new EmptyBoard().getBoard();
        }
        return new Tuple<>(board, end);
    }

    public static int getValuesLoop(Scanner scanner, String text) {
        int i = -1;
        while (i == -1) {
            System.out.println(text);
            int number = scanner.nextInt();
            i = ConsoleValidator.validValues(number);
        }
        return i;
    }
}
