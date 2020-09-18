package TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char [] [] gameBoard = {
                {' ', '|', ' ', '|', ' '},      //row 1
                {'-', '+', '-', '+', '-'},      //spacer row 1
                {' ', '|', ' ', '|', ' '},      //row 2
                {'-', '+', '-', '+', '-'},      //spacer row 2
                {' ', '|', ' ', '|', ' '}       //row 3
        };

        printBoard(gameBoard);                  //input our tic tac toe gameBoard into the printBoard method

        Scanner scan = new Scanner(System.in);          //create Scanner register "scan"
        System.out.println("Pick a spot, 1-9.");
        int userInput = scan.nextInt();                 //take the next int held in "scan" and put it in userInput
        System.out.println(userInput);                  //prints the integer in userInput

        placePiece(gameBoard,userInput,"player");  //replace one of the 3x3 empty spaces in our gameBoard with the userInput with an 'X'

        Random rand = new Random();                     //create Random register "rand"
        int cpuInput = rand.nextInt(9) + 1;      //generate a random number between 1 and 9
        placePiece(gameBoard,cpuInput,"cpu");     //replace one of the 3x3 spaces in our gameBoard with the cpuInput with an 'O'


        printBoard(gameBoard);

    }

    public static void printBoard(char [] [] gameBoard){
        for(char[] row : gameBoard) {           //for each 1-dimensional CHARacter array in gameBoard... (5)

            for(char c : row) {                 //and for each CHARacter in that 1-dimensional array of CHARacters
                System.out.print(c);            //PRINT as opposed to println, only prints one character
            }

            System.out.println();               //after each char in that iterated row have printed, start a new line and loop back to iterate next row or exit loop

        }
    }

    public static void placePiece(char [] [] gameBoard, int spot, String user){

        char symbol = ' ';

        if(user.equals("player")) {
            symbol = 'X';
        } else if(user.equals("cpu")) {
            symbol = 'O';
        }

        switch(spot){
            case 1:
                gameBoard [0] [0] = symbol;
                break;

            case 2:
                gameBoard [0] [2] = symbol;
                break;

            case 3:
                gameBoard [0] [4] = symbol;
                break;

            case 4:
                gameBoard [2] [0] = symbol;
                break;

            case 5:
                gameBoard [2] [2] = symbol;
                break;

            case 6:
                gameBoard [2] [4] = symbol;
                break;

            case 7:
                gameBoard [4] [0] = symbol;
                break;

            case 8:
                gameBoard [4] [2] = symbol;
                break;

            case 9:
                gameBoard [4] [4] = symbol;
                break;

            default:
                break;
        }

    }

}
