package com.kodilla.tictac_toe;

import java.util.Scanner;

public class UserDialogs {
    private static Figure whoseMove = Figure.X;

    public static Move getMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            oppositeFigure();
            System.out.println("Next move: " + whoseMove);
            System.out.println("Enter your move in format X,Y:");
            String s = scanner.nextLine();
            try {
                String[] splitted = s.split(",");
                if (splitted.length != 2) {
                    oppositeFigure();
                    throw new Exception("You have to specify 2 tokens");
                }
                int col = Integer.parseInt(splitted[0].trim());
                if (col > board.getRows().size() || col <= 0) {
                    oppositeFigure();
                    throw new Exception("Column is greater than " + board.getRows().size() + " or less than 1");
                }
                int row = Integer.parseInt(splitted[1].trim());
                if (row > board.getRows().size() || row <= 0) {
                    oppositeFigure();
                    throw new Exception("Row is greater than" + board.getRows().size() + " or less than 1");
                }
                return switch (whoseMove.toString()) {
                    case "O" -> new Move(col, row, Figure.O);
                    case "X" -> new Move(col, row, Figure.X);
                    default -> throw new Exception("Unknown figure");
                };
            } catch (Exception e) {
                System.out.println("Wrong move, try again, " + e);
            }

        }
    }

    protected static void oppositeFigure() {
        if (whoseMove == Figure.O) {
            whoseMove = Figure.X;
        } else {
            whoseMove = Figure.O;
        }

    }
}
