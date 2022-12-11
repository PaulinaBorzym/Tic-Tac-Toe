package com.kodilla.tictac_toe;

import java.util.Random;
import java.util.Scanner;

public class ComputerDialogs {
    public static Move getComputerMove() {
        Random random = new Random();
        int col = random.nextInt(3);
        int row = random.nextInt(3);
        UserDialogs.oppositeFigure();
        return new Move(col +1,row + 1,Figure.X);
    }

}


