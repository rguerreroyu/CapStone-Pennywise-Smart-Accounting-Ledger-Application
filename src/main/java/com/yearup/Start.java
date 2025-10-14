package com.yearup;

public class Start {
    public static void main(String[] args) {

        HomeScreen.ShowHomeScreen();

        System.out.println("Looking in: " + new java.io.File(".").getAbsolutePath());
    }
}
