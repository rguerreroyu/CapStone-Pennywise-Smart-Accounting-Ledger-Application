package com.yearup;

import java.util.Scanner;

public class HomeScreen {
    public static void ShowHomeScreen() {
        //options list = new optionslist();
        //list.loadFromCsv("transaction.csv");


        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to your accounting ledger application!");
            System.out.println("Choose an option:");
            System.out.println("D. Add Deposit");
            System.out.println("P. Make payment (Debit)");
            System.out.println("L. Ledger");
            System.out.println("X. Exit");
            System.out.print("Pick here: ");

            char choice = scanner.next().charAt(0);
            switch (choice) {
                case 'D' -> System.out.println("You chose to add a deposit");
                case 'P' -> System.out.println("You chose to make a payment");
                case 'L' -> System.out.println("You chose ledger");
                case 'X' -> {
                    System.out.println("Goodbye, Thank you!");
                    running = false;
                }

                default -> System.out.println("Invalid choice, try again!");
            }
        }




    }
}
