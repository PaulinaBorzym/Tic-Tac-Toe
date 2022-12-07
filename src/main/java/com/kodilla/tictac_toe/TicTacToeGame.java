package com.kodilla.tictac_toe;

class TicTacToeGame {

    public void playGame() {
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
        if (isWinner(board)) {
            System.out.println("End the game. The winner is: " + move.getFigure());
        }
        if (checkFullBoard(board)) {
            System.out.println("End the game. Nobody win.");
        }
    }

    private boolean validateMove(Move move, Board board) {
        return board.getFigure(move.getCol() - 1, move.getRow() - 1) == Figure.NONE;
    }

    private boolean isWinner(Board board) {
        return checkCols(board) || checkRows(board) || checkDiagonals(board);
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
}
