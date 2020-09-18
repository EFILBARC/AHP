package bank.sys;

import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        BankAcc ahp = new BankAcc("Adam", "2326KYS");
        ahp.showMenu();

    }
}

    class BankAcc {
        int bal = 0;
        int prevX;
        String name;
        String ID;

        BankAcc(String cName, String cID) {
            name = cName;
            ID = cID;
        }

        void deposit(int amount) {
            bal = bal + amount;
            prevX = amount;
            System.out.println("Your new balance is $" + bal + ".");
        }

        void withdraw(int amount) {
            if (amount <= bal && amount > 0) {
                bal = bal - amount;
                prevX = -amount;
                System.out.println("Your new balance is $" + bal + ".");
            }
            else if(amount <= 0){
            }
            else {
                System.out.println("You can only withdraw up to $" + bal + ".");
                System.out.println("TRANSACTION DENIED.");
            }
        }

        void getPrevX() {
            if (prevX > 0) {
                System.out.println("The last transaction was a deposit of $" + prevX + ".");
            } else if (prevX < 0) {
                System.out.println("The last transaction was a withdrawal of " + Math.abs(prevX) + ".");
            } else {
                System.out.println("You have not made any transactions during this session.");
            }

        }

        void showMenu() {
            char option = 'A';
            Scanner selected = new Scanner(System.in);

            int i = 0;

            System.out.println("Hello " + name + ". (customer ID: " + ID + ")");
            System.out.println("");
            System.out.println("MAIN MENU");
            System.out.println("B: Check Balance");
            System.out.println("D: Deposit");
            System.out.println("W: Withdraw");
            System.out.println("X: Transaction History");
            System.out.println("E: Exit Session");

            do {
                System.out.println(" ~~~ ");
                if (i == 0) {
                    System.out.println("Select your option.");
                } else {

                    System.out.println("If you would like to continue, select another option. To exit, select ''E''.");

                }
                System.out.println(" ~~~ ");
                option = selected.next().charAt(0);
                System.out.println("");


                switch (option) {

                    case 'B':
                        System.out.println(" ~~~ ");
                        System.out.println("Your balance is $" + bal +".");
                        System.out.println(" ~~~ ");
                        i++;
                        break;

                    case 'D':
                        System.out.println(" ~~~ ");
                        System.out.println("How much would you like to deposit?");
                        System.out.println(" ~~~ ");
                        int amountToDeposit = selected.nextInt();
                        deposit(amountToDeposit);
                        i++;
                        break;

                    case 'W':
                        System.out.println(" ~~~ ");
                        System.out.println("How much would you like to withdraw?");
                        System.out.println(" ~~~ ");
                        int amountToWithdraw = selected.nextInt();
                        withdraw(amountToWithdraw);
                        i++;
                        break;

                    case 'X':
                        System.out.println(" ~~~ ");
                        getPrevX();
                        System.out.println(" ~~~ ");
                        i++;
                        break;

                    case 'E':
                        System.out.println(" **************** ");
                        i = 0;
                        break;

                    default:
                        System.out.println("Please enter a valid option.");
                        break;


                }
            } while (option != 'E');

            System.out.println("Thank you for using AHP Bank.");
        }
    }