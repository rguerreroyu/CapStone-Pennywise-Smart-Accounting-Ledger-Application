package com.yearup;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ledger {
    private static final String fileName = "transactions.csv";
    private static final List<Transactions> transactions = reader();

    public void ShowLedger() {

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

                case "a":
                    System.out.println("Displaying all entries");
                  displayAll(transactions);

                    break;


                case "d":
                    System.out.println("Displaying all deposits");
                    displayDeposits(transactions);
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


    private static List<Transactions>reader(){
        List<Transactions>list= new ArrayList<Transactions>();
        try
        {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("transactions.csv");
            // create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            // read until there is no more data
            while((input = bufReader.readLine()) != null) {
                String[] info = input.split("\\|");
                LocalDate date = LocalDate.parse(info[0]);
                LocalTime time = LocalTime.parse(info[1]);
                String description = info[2];
                String vendor = info[3];
                double amount = Double.parseDouble(info[4]);
                //System.out.println(input);
                Transactions entry = new Transactions(date, time, description, vendor, amount);
                list.add(entry);
            }
            // close the stream and release the resources
            bufReader.close();
        }
        catch(IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
        return list;
    }

    private static void displayAll(List<Transactions> list)  {
        for(var i = list.size() - 1; i >=0; i--){
            System.out.println(list.get(i).toString());

        }

    }

    private static void displayDeposits(List<Transactions> list){
        for(var i = list.size() - 1; i >=0; i--){
            if (list.get(i).getAmount() >=0){
                System.out.println(list.get(i).toString());

            }
        }

    }
}
