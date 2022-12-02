package com.kodilla.tictac_toe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<BoardRow> rows = new ArrayList<>();
    public Board() {
        for (int n=0; n<3; n++)
            rows.add(new BoardRow());
    }
    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setFigures(int col, int row, Figure figure) {
        rows.get(row).getCols().set(col, figure);
    }

    @Override
    public String toString(){
        String s = "|---|---|---|\n";
        for (int row = 0; row < rows.size(); row ++ ) {
            s += rows.get(row).toString();
        }
        s += "|---|---|---|\n";
        return s;
        }
}
