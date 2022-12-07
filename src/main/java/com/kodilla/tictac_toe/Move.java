package com.kodilla.tictac_toe;

public class Move {
    private final int col;
    private final int row;
    private final Figure figure;

    public Move(int col, int row, Figure figure) {
        this.col = col;
        this.row = row;
        this.figure = figure;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Figure getFigure() {
        return figure;
    }
}
