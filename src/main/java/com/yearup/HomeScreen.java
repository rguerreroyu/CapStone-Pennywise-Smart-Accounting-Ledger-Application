package com.yearup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class HomeScreen {

    public static void Loading(String message) {

        System.out.println("\n" + message);
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void ShowWelcomeScreen(){
        Loading("Welcome to...");
        Loading(
                " ██▓███     ▓█████     ███▄    █     ███▄    █    ▓██   ██▓    █     █░    ██▓     ██████    ▓█████ \n" +
                        "▓██░  ██▒   ▓█   ▀     ██ ▀█   █     ██ ▀█   █     ▒██  ██▒   ▓█░ █ ░█░   ▓██▒   ▒██    ▒    ▓█   ▀ \n" +
                        "▓██░ ██▓▒   ▒███      ▓██  ▀█ ██▒   ▓██  ▀█ ██▒     ▒██ ██░   ▒█░ █ ░█    ▒██▒   ░ ▓██▄      ▒███   \n" +
                        "▒██▄█▓▒ ▒   ▒▓█  ▄    ▓██▒  ▐▌██▒   ▓██▒  ▐▌██▒     ░ ▐██▓░   ░█░ █ ░█    ░██░     ▒   ██▒   ▒▓█  ▄ \n" +
                        "▒██▒ ░  ░   ░▒████▒   ▒██░   ▓██░   ▒██░   ▓██░     ░ ██▒▓░   ░░██▒██▓    ░██░   ▒██████▒▒   ░▒████▒\n" +
                        "▒▓▒░ ░  ░   ░░ ▒░ ░   ░ ▒░   ▒ ▒    ░ ▒░   ▒ ▒       ██▒▒▒    ░ ▓░▒ ▒     ░▓     ▒ ▒▓▒ ▒ ░   ░░ ▒░ ░\n" +
                        "░▒ ░         ░ ░  ░   ░ ░░   ░ ▒░   ░ ░░   ░ ▒░    ▓██ ░▒░      ▒ ░ ░      ▒ ░   ░ ░▒  ░ ░    ░ ░  ░\n" +
                        "░░             ░         ░   ░ ░       ░   ░ ░     ▒ ▒ ░░       ░   ░      ▒ ░   ░  ░  ░        ░   \n");
        Loading("\nPennyWise: Your Smart Accounting Ledger 🎈");

        //System.out.println("\nPress ENTER to continue...");
    }



    public void ShowHomeScreen() {
        //options list = new optionslist();
        //list.loadFromCsv("transaction.csv");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {




            Loading ("Choose an option:");

            System.out.println("D. Add Deposit");
            System.out.println("=====================");

            System.out.println("P. Make payment (Debit)");
            System.out.println("=====================");

            System.out.println("L. Ledger");
            System.out.println("=====================");

            System.out.println("X. Exit");

            System.out.print("Pick here: ");

            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {

                case "d" :
                    System.out.println("\n\n==== ENTER A DEPOSIT ====");
                    LocalDate dateD = LocalDate.now();
                    LocalTime time = LocalTime.now();

                    System.out.println("Enter the description");
                    String description = scanner.nextLine();
                    System.out.println("Enter vendor name");
                    String vendor = scanner.nextLine();
                    System.out.println("Enter the amount");
                    double amount = Double.parseDouble(scanner.nextLine());
                    //date|time|description|vendor|amount
                    String deposit = dateD +"|" + time + "|" + description + "|" + vendor + "|" + amount;
                    FileInput(deposit);
                    System.out.println("Printed to file");

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
                    FileInput(entryP);
                    break;

                case "l" :
                    System.out.println("You chose ledger");
                    Ledger ledger = new Ledger();
                    ledger.ShowLedger();
                     break;

                case "x" : {
                    System.out.println("Goodbye, Thank you!");
                    System.exit(0);
                }

//                default -> System.out.println("Invalid choice, try again!");
            }
        }





    }

    public void FileInput(String input) {
        try {
            // create a FileWriter
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.append(input).append("\n");
            bufWriter.flush();
            bufWriter.close();
        }


        catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }

    }


}
