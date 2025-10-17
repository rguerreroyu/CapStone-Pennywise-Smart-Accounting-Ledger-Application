package com.yearup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class HomeScreen {
    public void ShowWelcomeScreen(){
        System.out.println("Welcome to...");
        System.out.println(
                " ██▓███     ▓█████     ███▄    █     ███▄    █    ▓██   ██▓    █     █░    ██▓     ██████    ▓█████ \n" +
                        "▓██░  ██▒   ▓█   ▀     ██ ▀█   █     ██ ▀█   █     ▒██  ██▒   ▓█░ █ ░█░   ▓██▒   ▒██    ▒    ▓█   ▀ \n" +
                        "▓██░ ██▓▒   ▒███      ▓██  ▀█ ██▒   ▓██  ▀█ ██▒     ▒██ ██░   ▒█░ █ ░█    ▒██▒   ░ ▓██▄      ▒███   \n" +
                        "▒██▄█▓▒ ▒   ▒▓█  ▄    ▓██▒  ▐▌██▒   ▓██▒  ▐▌██▒     ░ ▐██▓░   ░█░ █ ░█    ░██░     ▒   ██▒   ▒▓█  ▄ \n" +
                        "▒██▒ ░  ░   ░▒████▒   ▒██░   ▓██░   ▒██░   ▓██░     ░ ██▒▓░   ░░██▒██▓    ░██░   ▒██████▒▒   ░▒████▒\n" +
                        "▒▓▒░ ░  ░   ░░ ▒░ ░   ░ ▒░   ▒ ▒    ░ ▒░   ▒ ▒       ██▒▒▒    ░ ▓░▒ ▒     ░▓     ▒ ▒▓▒ ▒ ░   ░░ ▒░ ░\n" +
                        "░▒ ░         ░ ░  ░   ░ ░░   ░ ▒░   ░ ░░   ░ ▒░    ▓██ ░▒░      ▒ ░ ░      ▒ ░   ░ ░▒  ░ ░    ░ ░  ░\n" +
                        "░░             ░         ░   ░ ░       ░   ░ ░     ▒ ▒ ░░       ░   ░      ▒ ░   ░  ░  ░        ░   \n");
        System.out.println("\nPennywise: Your Smart Accounting Ledger 🎈");

        //System.out.println("\nPress ENTER to continue...");
    }



    public void ShowHomeScreen() {
        //options list = new optionslist();
        //list.loadFromCsv("transaction.csv");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {




            System.out.println("Choose an option:");
            System.out.println("D. Add Deposit");
            System.out.println("P. Make payment (Debit)");
            System.out.println("L. Ledger");
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
                    String entry = dateD +"|" + time + "|" + description + "|" + vendor + "|" + amount;
                    FileInput(entry);
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
                    running = false;
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
            // write to the file
           bufWriter.append(input + "\n");

            // close the writer
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR:  An unexpected error occurred");
            e.getStackTrace();
        }

    }


}
