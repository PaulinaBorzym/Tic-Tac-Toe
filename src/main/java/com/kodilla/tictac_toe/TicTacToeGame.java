package com.kodilla.tictac_toe;

import java.util.Scanner;

import static java.lang.Math.abs;

class TicTacToeGame {

    public void playGame() {
        boolean isPlaying3X3 = isPlaying3X3();
        Board board = new Board(isPlaying3X3);
        System.out.println(board);
        boolean valid = false;
        Move move = null;
        boolean isPlayingWithComputer = isPlayingWithComputer();
        int countMoves = 1;
        while (!isWinner(board, isPlaying3X3) && !checkFullBoard(board)) {
            if(isPlayingWithComputer && countMoves%2 == 0){
                move = ComputerDialogs.getComputerMove(isPlaying3X3);
            } else {
                move = UserDialogs.getMove(board);
            }
            valid = validateMove(move, board);
            if (!valid) {
                System.out.println("This move is illegal. Try again.");
                UserDialogs.oppositeFigure();
                continue;
            }

            board.setFigures(move.getCol() - 1, move.getRow() - 1, move.getFigure());
            System.out.println(board);
            countMoves ++;
        }
        if (isWinner(board, isPlaying3X3)) {
            System.out.println("End the game. The winner is: " + move.getFigure());
        }
        if (checkFullBoard(board)) {
            System.out.println("End the game. Nobody win.");
        }
    }

    private boolean validateMove(Move move, Board board) {
        return board.getFigure(move.getCol() - 1, move.getRow() - 1) == Figure.NONE;
    }

    protected boolean isWinner(Board board, boolean isPlaying3X3) {
        if(isPlaying3X3) {
            return checkCols(board) || checkRows(board) || checkDiagonals(board);
        }
        return checkCols10X10(board) || checkRows10X10(board) || checkDiagonals10X10(board);
    }

    private boolean checkCols(Board board) {
        for (int col = 0; col < 3; col++) {
            if (checkCol(board, col)) return true;
        }
        return false;
    }

    private boolean checkCol(Board board, int col) {
        boolean allO = true;
        boolean allX = true;
        for (int row = 0; row < board.getRows().size(); row++) {
            if (board.getFigure(col, row) != Figure.O)
                allO = false;
            if (board.getFigure(col, row) != Figure.X)
                allX = false;
        }
        return allO || allX;
    }

    private boolean checkRows(Board board) {
        for (int row = 0; row < 3; row++) {
            if (checkRow(board, row)) return true;
        }
        return false;
    }

    private boolean checkRow(Board board, int row) {
        boolean allO = true;
        boolean allX = true;
        for (int col = 0; col < board.getRows().size(); col++) {
            if (board.getFigure(col, row) != Figure.O)
                allO = false;
            if (board.getFigure(col, row) != Figure.X)
                allX = false;
        }
        return allO || allX;
    }

    private boolean checkDiagonals(Board board) {
        boolean allDownX = true;
        boolean allUpX = true;
        boolean allDownO = true;
        boolean allUpO = true;
        for (int n = 0; n < board.getRows().size(); n++) {
            if (board.getFigure(n, n) != Figure.O)
                allDownO = false;
            if (board.getFigure(n, n) != Figure.X) {
                allDownX = false;
            }
            if (board.getFigure(n, board.getRows().size() - n - 1) != Figure.O)
                allUpO = false;
            if (board.getFigure(n, board.getRows().size() - n - 1) != Figure.X)
                allUpX = false;
        }
        return allDownO || allDownX || allUpO || allUpX;
    }

    private boolean checkFullBoard(Board board) {
        return board.getRows().stream()
                .flatMap(row -> row.getCols().stream())
                .filter(figure -> figure == Figure.NONE)
                .findAny()
                .isEmpty();
    }
    private boolean isPlayingWithComputer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to play with computer press \"C\". " +
                "\nIf you want to play with other user press other key");
        String s = scanner.nextLine();
        if(s.toUpperCase().equals("C")){
            return true;
        }
        return false;
    }
    private boolean isPlaying3X3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to play version 3X3 press \"3\"." +
                "\nIf you want to play version 10X10 press \"10\"");
        String s = scanner.nextLine();
        if(s.equals("3")) {
            return true;
        }
        return false;
        }

    private boolean checkCols10X10(Board board) {
        for (int col = 0; col < 10; col++) {
            if (checkCol10X10(board, col)) return true;
        }
        return false;
    }
    private boolean checkCol10X10(Board board, int col) {
        boolean allO = false;
        boolean allX = false;
        int countO = 0;
        int countX = 0;
        for (int row = 0; row < board.getRows().size(); row++) {
            if (board.getFigure(col, row) == Figure.O){
                countO++;
                if (countO == 5)
                    allO = true;
                if(board.getFigure(col, row) == Figure.X || (board.getFigure(col, row) == Figure.NONE ))
                    countO = 0;
               }
            if (board.getFigure(col, row) == Figure.X){
                countX ++;
                if(board.getFigure(col,row) == Figure.O || (board.getFigure(col, row) == Figure.NONE ))
                    countX = 0;
                if (countX == 5)
                allX = true;
            }
        }
        return allO || allX;
    }
    private boolean checkRows10X10(Board board) {
        for (int row = 0; row < 10; row++) {
            if (checkRow10X10(board, row))
                return true;
        }
        return false;
    }

    private boolean checkRow10X10(Board board, int row) {
        boolean allO = false;
        boolean allX = false;
        int countO = 0;
        int countX = 0;
        for (int col = 0; col < board.getRows().size(); col++) {
            if (board.getFigure(col, row) == Figure.O) {
                countO++;
                if (countO == 5)
                    allO = true;
                if (board.getFigure(col, row) == Figure.X || (board.getFigure(col, row) == Figure.NONE))
                    countO = 0;
            }
            if (board.getFigure(col, row) == Figure.X) {
                countX++;
                if (board.getFigure(col, row) == Figure.O || (board.getFigure(col, row) == Figure.NONE))
                    countX = 0;
                if (countX == 5)
                    allX = true;
            }
        }
        return allO || allX;
    }
    private boolean checkDiagonals10X10(Board board) {
        if (board.getRows().size() > 5) {
            for (int colStart = 0; colStart < board.getRows().size() - 5 + 1; colStart++) {
                for (int rowStart = 0; rowStart < board.getRows().size() - 5 + 1; rowStart++) {
                    if (checkOneRightSubDiagonal(colStart, rowStart, board))
                        return true;
                }
            }
            for (int colStart = board.getRows().size() - 5 - 1; colStart < board.getRows().size() - 1; colStart++) {
                for (int rowStart = 0; rowStart < board.getRows().size() - 5 + 1; rowStart++) {
                    if (checkOneLeftSubDiagonal(colStart, rowStart, board))
                        return true;
                }
            }
        }
            return false;
    }
            private boolean checkOneRightSubDiagonal ( int col, int row, Board board){
                boolean resultX = true;
                boolean resultO = true;
                for (int n = 0; n < 5; n++) {
                    resultX = resultX && (board.getFigure(col + n, row + n) == Figure.X);
                    resultO = resultO && (board.getFigure(col + n, row + n) == Figure.O);
                }
                return resultX || resultO;
            }
            private boolean checkOneLeftSubDiagonal ( int col, int row, Board board){
                boolean resultX = true;
                boolean resultO = true;
                for (int n = 0; n > -5; n--) {
                    resultX = resultX && (board.getFigure(col + n, row + abs(n)) == Figure.X);
                    resultO = resultO && (board.getFigure(col + n, row + abs(n)) == Figure.O);
                }
                return resultX || resultO;
            }
        }

