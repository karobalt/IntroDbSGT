package com.company.finalproject;

import java.util.Scanner;

public class TodoListMenu {

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do?: ");
        System.out.println("1. Sign Up");
        System.out.println("2. Log in");

        System.out.println("Select and option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(TodoListController.signUp());
                TodoListController.logIn();
                break;
            case 2:
                System.out.println(TodoListController.logIn());
                TodoListMenu.loginMenu();
                break;
            default:
                System.out.println("Invalid option. Try again");
                mainMenu();

        }

    }

    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to do next?: ");
        System.out.println("1. Add to-do list item");
        System.out.println("2. Edit to-do list item");
        System.out.println("3. Delete to-do list item");

        System.out.println("Select and option: ");
        int option2 = scanner.nextInt();

        switch (option2) {
            case 1:
                System.out.println(TodoListController.addTask());
                break;
            case 2:
                System.out.println(TodoListController.editTask());
                break;
            case 3:
                System.out.println(TodoListController.deleteTask());
                break;
            default:
                System.out.println("Invalid option. Try again");
                loginMenu();

        }
    }

}
