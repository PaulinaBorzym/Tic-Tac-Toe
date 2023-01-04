package com.kodilla.tictac_toe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.xmlunit.builder.Input;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TicTacToeTestSuit {
    @Test
    void testOWinsInRow() {
        //Given
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        Board board = new Board(true);
        //When
        board.setFigures(0,0,Figure.O);
        board.setFigures(0,2,Figure.X);
        board.setFigures(1,0,Figure.O);
        board.setFigures(1,1,Figure.X);
        board.setFigures(2,0,Figure.O);
        boolean result = ticTacToeGame.isWinner(board,true);
        //Then
        Assertions.assertTrue(result);
    }
    @Test
    void testOWinsInCol() {
        //Given
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        Board board = new Board(true);
        //When
        board.setFigures(0,0, Figure.O);
        board.setFigures(2,1, Figure.X);
        board.setFigures(0,1, Figure.O);
        board.setFigures(2,2, Figure.X);
        board.setFigures(0,2, Figure.O);
        boolean result = ticTacToeGame.isWinner(board, true);
        //Then
        Assertions.assertTrue(result);
    }
    @Test
    void testOWinsInDiagonal() {
        //Given
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        Board board = new Board(true);
        //When
        board.setFigures(0,0, Figure.O);
        board.setFigures(2,0, Figure.X);
        board.setFigures(1,1, Figure.O);
        board.setFigures(1,2, Figure.X);
        board.setFigures(2,2, Figure.O);
        boolean result = ticTacToeGame.isWinner(board, true);
        //Then
        Assertions.assertTrue(result);
    }
    @Test
    void testXWinsInRow() {
        //Given
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        Board board = new Board(true);
        //When
        board.setFigures(1,2,Figure.O);
        board.setFigures(0,0,Figure.X);
        board.setFigures(0,2,Figure.O);
        board.setFigures(1,0,Figure.X);
        board.setFigures(1,1,Figure.O);
        board.setFigures(2,0,Figure.X);
        boolean result = ticTacToeGame.isWinner(board, true);
        //Then
        Assertions.assertTrue(result);
    }
    @Test
    void testXWinsInCol() {
        //Given
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        Board board = new Board(true);
        //When
        board.setFigures(1,2, Figure.O);
        board.setFigures(0,0, Figure.X);
        board.setFigures(2,1, Figure.O);
        board.setFigures(0,1, Figure.X);
        board.setFigures(2,2, Figure.O);
        board.setFigures(0,2, Figure.X);
        boolean result = ticTacToeGame.isWinner(board, true);
        //Then
        Assertions.assertTrue(result);
    }
    @Test
    void testXWinsInDiagonal() {
        //Given
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        Board board = new Board(true);
        //When
        board.setFigures(0,0, Figure.O);
        board.setFigures(0,2, Figure.X);
        board.setFigures(1,0, Figure.O);
        board.setFigures(1,1, Figure.X);
        board.setFigures(2,2, Figure.O);
        board.setFigures(2,0, Figure.X);
        boolean result = ticTacToeGame.isWinner(board,true);
        //Then
        Assertions.assertTrue(result);
    }
    @Test
    void testNobodyWins(){
        //Given
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        Board board = new Board(true);
        //When
        board.setFigures(0,0, Figure.O);
        board.setFigures(0,1, Figure.X);
        board.setFigures(0,2, Figure.O);
        board.setFigures(1,0, Figure.X);
        board.setFigures(1,1, Figure.O);
        board.setFigures(2,0, Figure.X);
        board.setFigures(1,2, Figure.O);
        board.setFigures(2,2, Figure.X);
        board.setFigures(2,1, Figure.O);
        boolean result = ticTacToeGame.isWinner(board, true);
        //Then
        Assertions.assertEquals(false,result);
    }
    @Test
    void exceptionToMuchTokens(){
        //Given
        UserDialogs userDialogs = new UserDialogs();
        Board board = new Board(true);
        String input = "2,2,3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //When & Then
        Assertions.assertThrows(Exception.class , ()-> userDialogs.getMove(board));
    }
    @Test
    void exceptionWrongNumberOfCol(){
        //Given
        UserDialogs userDialogs = new UserDialogs();
        Board board = new Board(true);
        String input = "4,2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //When & Then
        Assertions.assertThrows(Exception.class , ()-> userDialogs.getMove(board));
    }
    @Test
    void exceptionWrongNumberOfRow(){
        //Given
        UserDialogs userDialogs = new UserDialogs();
        Board board = new Board(true);
        String input = "1,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //When & Then
        Assertions.assertThrows(Exception.class , ()-> userDialogs.getMove(board));
    }
}
