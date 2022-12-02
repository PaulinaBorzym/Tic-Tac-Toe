package com.kodilla.tictac_toe;

import java.util.Scanner;

public class UserDialogs {
    public static Move getMove(){
        Figure whoseMove = Figure.O;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter your move in format X,Y,F:");
            String s =  scanner.nextLine();
            try {
                String[] splitted = s.split(",");
                if(splitted.length != 3)
                    throw new Exception("You have to specify 3 tokens");
                int col = Integer.parseInt(splitted[0].trim());
                if(col>3 || col <= 0)
                    throw new Exception("Column is greater than 3 or less than 1");
                int row = Integer.parseInt(splitted[1].trim());
                if(row>3 || row <= 0)
                    throw new Exception("Row is greater than 3 or less than 1");
                switch (splitted[2].trim().toUpperCase()){
                    case "O" : return new Move(col,row, Figure.O);
                    case "X" : return new Move(col,row, Figure.X);
                    default: throw new Exception("Unknown figure");
                }
            } catch (Exception e) {
                System.out.println("Wrong move, try again, " + e);
            }
            oppositeFigure(whoseMove);
            System.out.println("Next move: " + whoseMove);
        }
    }
    private static Figure oppositeFigure(Figure figure) {
        return (figure == Figure.O ? Figure.X : Figure.O);
    }
}
