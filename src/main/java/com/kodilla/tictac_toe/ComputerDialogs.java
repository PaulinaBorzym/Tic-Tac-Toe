package com.kodilla.tictac_toe;

import java.util.Random;
import java.util.Scanner;

public class ComputerDialogs {
    public static Move getComputerMove(boolean isPlaying3X3) {
        Random random = new Random();
        int col, row;
        if(isPlaying3X3) {
            col = random.nextInt(3);
            row = random.nextInt(3);
        }else {
            col = random.nextInt(10);
            row = random.nextInt(10);
        }
            UserDialogs.oppositeFigure();
            return new Move(col + 1, row + 1, Figure.X);
    }
}


