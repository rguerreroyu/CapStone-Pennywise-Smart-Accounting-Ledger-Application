package com.yearup;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Scanner;


//import static com.yearup.Ledger.reader;

public class Reports {
    private static final String fileName = "transactions.csv";

    public void ShowReports() {


        Scanner scanner = new Scanner(System.in);
        boolean running = true;
//1) Month To Date
//§ 2) Previous Month
//§ 3) Year To Date
//§ 4) Previous Year
//§ 5) Search by Vendor - prompt the user for the vendor name
//and display all entries for that vendor
//§ 0) Back - go back to the Ledger page
//o H) Home - go back to the home page
        while (running) {
            System.out.println("\\==== REPORTS SCREEN ====\"");
            System.out.println("Choose an option to search by:");
            System.out.println("1. Search by Month To Date ");
            System.out.println("2. Search by Previous Month");
            System.out.println("3. Search by Year to Date");
            System.out.println("4. Search by Previous Year ");
            System.out.println("5. Search by Vendor ");
            System.out.println(("0. Back to Ledger"));
            System.out.println(("H. Back to Homescreen"));
            System.out.print("Pick here: ");

            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {

                case "1":
                    System.out.println("Displaying entries by Month to Date");
                    displayMonthToDate(Ledger.reader());
                    break;


                case "2":
                    System.out.println("Displaying entries by Previous Month");
                    displayPreviousMonth(Ledger.reader());
                    break;

                case "3":
                    System.out.println("Displaying entries by Year to Date ");
                    displayYearToDate(Ledger.reader());
                    break;


                case "4":
                    System.out.println("Displaying entries by Previous Year");
                    displayPreviousYear(Ledger.reader());
                    break;

                case "5":
                    System.out.println("Search entries by Vendor");
                    displayByVendor(Ledger.reader());
                    break;

                case "0":
                    System.out.println("Back to ledger");
                    Ledger ledger = new Ledger();
                    ledger.ShowLedger();
                    break;

                case "h": {
                    System.out.println("Back to homescreen");

                    running = false;
                }


//                default -> System.out.println("Invalid choice, try again!");
            }

        }
    }

    private static void displayMonthToDate(List<Transactions> list) {
        LocalDate today = LocalDate.now();
        Year currentYear = Year.of((LocalDate.now().getYear()));
        Month currentMonth = LocalDate.now().getMonth();


        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();

            if (transactionDate.getYear() == currentYear.getValue() && transactionDate.getMonth() == currentMonth) {
                System.out.println(list.get(i));
            }
        }

    }

    private static void displayPreviousMonth(List<Transactions> list) {
        LocalDate today = LocalDate.now();
        LocalDate previousMonthDate = today.minusMonths(1);
        Year previousYear = Year.of(previousMonthDate.getYear());
        Month previousMonth = previousMonthDate.getMonth();
        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();

            if (transactionDate.getYear() == previousYear.getValue() && transactionDate.getMonth() == previousMonth) {
                System.out.println(list.get(i));
            }
        }


    }

    private static void displayYearToDate(List<Transactions> list) {
        LocalDate today = LocalDate.now();
        Year currentYear = Year.of(today.getYear());

        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();

            if (transactionDate.getYear() == currentYear.getValue() && !transactionDate.isAfter(today)) {
                System.out.println(list.get(i));
            }
        }
    }

    private static void displayPreviousYear(List<Transactions> list) {
        LocalDate today = LocalDate.now();
        Year previousYear = Year.of(today.getYear() - 1);

        for (var i = list.size() - 1; i >= 0; i--) {
            LocalDate transactionDate = list.get(i).getDate();

            if (transactionDate.getYear() == previousYear.getValue()) {
                System.out.println(list.get(i));
            }
        }
    }

    private static void displayByVendor(List<Transactions> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vendor name to search: ");
        String vendorSearch = scanner.nextLine().toLowerCase();

        for (var i = list.size() - 1; i >= 0; i--) {
            String transactionVendor = list.get(i).getVendor().toLowerCase();
            if (transactionVendor.contains(vendorSearch)) {
                System.out.println(list.get(i));
            }


        }
    }
}

//}
