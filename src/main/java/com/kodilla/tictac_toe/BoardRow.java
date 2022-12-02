package com.kodilla.tictac_toe;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<Figure> cols = new ArrayList<>();
    public BoardRow(){
        for(int n=0; n<3; n++)
            cols.add(Figure.NONE);
    }

    public List<Figure> getCols() {
        return cols;
    }
    @Override
    public String toString(){
        String s = "|";
        for(int col = 0; col<cols.size(); col++) {
            s += " " + getFigureSymbol(cols.get(col)) + " |";
        }
        s += "\n";
        return s;
    }

    private String getFigureSymbol(Figure figure) {
        switch (figure) {
            case O: return "O";
            case X: return "X";
            default: return " ";

        }
    }
}
