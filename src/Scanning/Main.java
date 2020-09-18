package Scanning;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input1 = new Scanner(System.in);
        String input = input1.toString();
        System.out.println("Input is " +input);

        char a = input1.next().charAt(0);
        System.out.println("char = " +a);


    }
}
