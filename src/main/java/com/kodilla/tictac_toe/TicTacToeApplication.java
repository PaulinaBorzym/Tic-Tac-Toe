package com.kodilla.tictac_toe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
        boolean valid = false;
        Move move = null;
        while (!isWinner(board) && !checkFullBoard(board)) {
            move = UserDialogs.getMove();
            valid = validateMove(move, board);
            if (!valid) {
                System.out.println("This move is illegal. Try again.");
                UserDialogs.oppositeFigure();
                continue;
            }

            board.setFigures(move.getCol() - 1, move.getRow() - 1, move.getFigure());
            System.out.println(board);
        }
        if(isWinner(board)) {
            System.out.println("End the game. The winner is: " + move.getFigure());
        }
        if (checkFullBoard(board)) {
            System.out.println("End the game. Nobody win.");
        }
    }

    private static boolean validateMove(Move move, Board board) {
        return board.getFigure(move.getCol()-1, move.getRow()-1) == Figure.NONE;
    }

    private static boolean isWinner(Board board){
        return checkCols(board) || checkRows(board) || checkDiagonals(board);
    }

    private static boolean checkCols(Board board) {
        for (int n = 0; n < 3; n++) {
            Figure col1 = board.getFigure(n, 0);
            Figure col2 = board.getFigure(n, 1);
            Figure col3 = board.getFigure(n, 2);
            if ((col1 == Figure.O && col2 == Figure.O && col3 == Figure.O) || (col1 == Figure.X && col2 == Figure.X && col3 == Figure.X)) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkRows(Board board) {
        for (int n = 0; n < 3; n++) {
            Figure row1 = board.getFigure(0, n);
            Figure row2 = board.getFigure(1, n);
            Figure row3 = board.getFigure(2, n);
            if ((row1 == Figure.O && row2 == Figure.O && row3 == Figure.O) || (row1 == Figure.X && row2 == Figure.X && row3 == Figure.X)) {
                return true;
            }
        }
        return false;
    }
    private static boolean checkDiagonals(Board board) {
        Figure figure1 = board.getFigure(0,0);
        Figure figure2 = board.getFigure(1,1);
        Figure figure3 = board.getFigure(2,2);
        Figure figure4 = board.getFigure(2,0);
        Figure figure5 = board.getFigure(0,2);
        if((figure1 == Figure.O && figure2 == Figure.O && figure3 == Figure.O) || (figure1 == Figure.X && figure2 == Figure.X && figure3 == Figure.X)
        || (figure2 == Figure.O && figure4 == Figure.O && figure5 == Figure.O) || (figure2 == Figure.X && figure4 == Figure.X && figure5 == Figure.X)) {
            return true;
        }
        return false;
    }
    private static boolean checkFullBoard(Board board){
        long quantityOfFigures = board.getRows().stream()
                .flatMap(row -> row.getCols().stream())
                .filter(col -> col.equals(Figure.O)|| col.equals(Figure.X))
                .count();
        if(quantityOfFigures == 9L)
            return true;
        return false;
    }
}
