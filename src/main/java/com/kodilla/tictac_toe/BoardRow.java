package com.kodilla.tictac_toe;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {

    private final List<Figure> cols = new ArrayList<>();

    public BoardRow(boolean isPlaying3X3) {
        if(isPlaying3X3) {
            for (int n = 0; n < 3; n++)
                cols.add(Figure.NONE);
        }else {
            for (int n = 0; n < 10; n++)
                cols.add(Figure.NONE);
        }
        }

    public List<Figure> getCols() {
        return cols;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("|");
        for (Figure figure : cols) {
            s.append(" ").append(getFigureSymbol(figure)).append(" |");
        }
        s.append("\n");
        return s.toString();
    }

    private String getFigureSymbol(Figure figure) {
        return switch (figure) {
            case O -> "O";
            case X -> "X";
            default -> " ";
        };
    }
}
