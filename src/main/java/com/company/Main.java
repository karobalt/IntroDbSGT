package com.company;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            scanner.nextInt();
        } catch (Exception e) {
            System.out.println("The value entered is not a string");
        }

    }
}
