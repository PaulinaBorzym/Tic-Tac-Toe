package com.kodilla.tictac_toe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<BoardRow> rows = new ArrayList<>();

    public Board(boolean isPlaying3X3) {
        if(isPlaying3X3) {
            for (int n = 0; n < 3; n++)
                rows.add(new BoardRow(isPlaying3X3));
        } else {
            for (int n = 0; n < 10; n++)
                rows.add(new BoardRow(isPlaying3X3));
        }
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public List<BoardRow> getRows() {
        return rows;
    }

    public void setFigures(int col, int row, Figure figure) {
        rows.get(row).getCols().set(col, figure);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(drawBoarder());
        for (BoardRow boardRow : rows) {
            s.append(boardRow.toString());
        }
        s.append(drawBoarder());
        return s.toString();
    }
    private String drawBoarder(){
        String boarder = "|";
        for(BoardRow boardRow : rows){
            boarder = boarder + "---|";
        }
        return boarder+"\n";
    }
}
