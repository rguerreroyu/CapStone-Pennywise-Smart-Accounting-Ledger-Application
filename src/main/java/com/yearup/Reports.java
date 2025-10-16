package com.yearup;

import java.util.Scanner;

public class Reports {
    public void ShowReports() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\\\\==== REPORTS SCREEN ====\"");
            System.out.println("Choose an option:");
            System.out.println("A. Display all entries");
            System.out.println("D. Display Deposits");
            System.out.println("P. Display Payments");
            System.out.println(("R. Reports"));
            System.out.println(("H. Homescreen"));
            System.out.print("Pick here: ");

            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {

                case "a":
                    System.out.println("Displaying all entries");

                    break;


                case "d":
                    System.out.println("Displaying all deposits");
                    break;

                case "p":
                    System.out.println("displaying all payments");
                    break;


                case "r":
                    System.out.println("Report page");
                    break;

                case "h": {
                    System.out.println("Back to homescreen");
                    running = false;
                }


//                default -> System.out.println("Invalid choice, try again!");
            }

        }
    }
}
