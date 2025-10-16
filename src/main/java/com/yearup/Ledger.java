package com.yearup;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Ledger {

        public void ShowLedger() {
            //options list = new optionslist();
            //list.loadFromCsv("transaction.csv");
//            All entries should show the newest entries first
//            o A) All - Display all entries
//            o D) Deposits - Display only the entries that are deposits into the
//            account
//            o P) Payments - Display only the negative entries (or payments)
//            o R) Reports - A new screen that allows the user to run pre-defined
//            reports or to run a custom search
//§         1) Month To Date
//§         2) Previous Month
//§         3) Year To Date
//§         4) Previous Year
//        5) Search by Vendor - prompt the user for the vendor name
//            and display all entries for that vendor
//§ 0) Back - go back to the Ledger page
//            o H) Home - go back to the home page
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\\n\\==== LEDGER SCREEN ====\"");
                System.out.println("Choose an option:");
                System.out.println("A. Display all entries");
                System.out.println("D. Display Deposits");
                System.out.println("P. Display Payments");
                System.out.println(("R. Reports"));
                System.out.println(("H. Homescreen"));
                System.out.print("Pick here: ");

                String choice = scanner.nextLine().toLowerCase();
                switch (choice) {

                    case "d" :
                        System.out.println("Displaying all entries");
                        LocalDate dateD = LocalDate.now();
                        LocalTime time = LocalTime.now();
                        System.out.println("Enter the description");
                        String description = scanner.nextLine();
                        System.out.println("Enter vendor name");
                        String vendor = scanner.nextLine();
                        System.out.println("Enter the amount");
                        double amount = Double.parseDouble(scanner.nextLine());
                        //date|time|description|vendor|amount
                        String entry = dateD +"|" + time + "|" + description + "|" + vendor + "|" + amount;
                        //FileInput(entry);
                        break;


                    case "p" :
                        System.out.println("You chose to make a payment");
                        LocalDate dateP = LocalDate.now();
                        LocalTime timeP = LocalTime.now();
                        System.out.println("Enter the description");
                        String descriptionP = scanner.nextLine();
                        System.out.println("Enter vendor name");
                        String vendorP = scanner.nextLine();
                        System.out.println("Enter the amount");
                        double amountP = -1 * Double.parseDouble(scanner.nextLine());
                        //date|time|description|vendor|amount
                        String entryP = dateP +"|" + timeP + "|" + descriptionP + "|" + vendorP + "|" + amountP;
                        System.out.println(entryP);
                        break;

                    case "l" :
                        System.out.println("You chose ledger");
                        break;

                    case "x" : {
                        System.out.println("Goodbye, Thank you!");
                        running = false;
                    }

//                default -> System.out.println("Invalid choice, try again!");
                }

            }
    }
}