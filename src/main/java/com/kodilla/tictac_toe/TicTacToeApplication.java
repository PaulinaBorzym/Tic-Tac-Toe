package com.kodilla.tictac_toe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

public class TicTacToeApplication {

    public static void main(String[] args) {
        Board board = new Board();
        board.setFigures(2,2,Figure.X);
        board.setFigures(1,2,Figure.O);
        System.out.println(board);
        boolean valid = false;
        Move move = null;
        while (isWinner()) {
            move = UserDialogs.getMove();
            valid = validateMove(move, board);
            if (!valid) {
                System.out.println("This move is illegal. Try again.");
                continue;
            }

            board.setFigures(move.getCol() - 1, move.getRow() - 1, move.getFigure());
            System.out.println(board);
        }
    }

    private static boolean validateMove(Move move, Board board) {
        return board.getFigure(move.getCol()-1, move.getRow()-1) == Figure.NONE;
    }

    private static boolean isWinner(){
        return true;
    }


}
