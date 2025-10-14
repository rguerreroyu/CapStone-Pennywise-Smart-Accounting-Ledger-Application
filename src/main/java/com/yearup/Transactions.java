package com.yearup;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transactions {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    public Transactions(LocalDate date, LocalTime time, String description, String vendor, double amount) throws IOException {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
//public Transactions(LocalDate String, LocalTime time, String description, String Vendor, double amount){


    @Override
    public String toString() {
        return "Transactions{" +
                "description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                ", time=" + time +
                ", date=" + date +
                '}';
    }

}



//    Transactions t = new Transactions
//
//}
