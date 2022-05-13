package com.company.login;

import com.company.dbhelper.DbConnection;
import static com.company.dbhelper.DbConnection.getConnection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean signUp() {
        // Prompt the user for data
        System.out.println("Enter your data for sign up: ");
        System.out.println("Enter the username: ");
        String username = scanner.next();
        System.out.println("Enter the password: ");
        String password = scanner.next();
        System.out.println("Enter the role (user or admin): ");
        String role = scanner.next();

        if (role.equalsIgnoreCase("user") || role.equalsIgnoreCase("admin")) {

            try {
                ps = getConnection().prepareStatement("INSERT INTO users(username, password, role) VALUES('" + username + "','" + password + "', '" + role + "');");
                ps.execute(); //execute the sql command
                return true; // return true if successful

            } catch (SQLException e) {
                System.out.println("Username is already taken. Try a different one.");
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            System.out.println("The" + role + "The role is invalid. Accepted values are shown in the prompt.");
            return false;
        }


    }
}
//    public static boolean logIn() {
//        // Prompt the user for data
//        System.out.println("Enter your data for log in: ");
//        System.out.println("Enter the username: ");
//        String username = scanner.next();
//        System.out.println("Enter the password: ");
//        String password = scanner.next();
//
//        if (username.equals(username) || role.equalsIgnoreCase("admin")) {
//
//            try {
//                ps = getConnection().prepareStatement("INSERT INTO users(username, password, role) VALUES('" + username + "','" + password + "', '" + role + "');");
//                ps.execute(); //execute the sql command
//                return true; // return true if successful
//
//            } catch (SQLException e) {
//                System.out.println("Username is already taken. Try a different one.");
//                System.out.println(e.getMessage());
//                return false;
//            }
//        } else {
//            System.out.println("The" + role + "The role is invalid. Accepted values are shown in the prompt.");
//            return false;
//        }
//
//
//    }
//}

    // Authentication

    // Write a method to sign up users on this student managment platform.
    // that allows them to have a username and password and a role.
    // The role is to be one of two items, ( user and admin) (validate it such that anything else that
    // is entered is not passed to the db
    // Make the username unique as well on your table (you can choose to make the username an email instead)

