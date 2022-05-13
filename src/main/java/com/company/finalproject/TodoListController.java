package com.company.finalproject;


import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.company.finalproject.DbConnection.getConnection;

public class TodoListController {
    // initialize the scanner
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean signUp() {
        System.out.println("Enter your data for sign up: ");
        System.out.println("Enter the username: ");
        String username = scanner.next();
        System.out.println("Enter the password: ");
        String password = scanner.next();

        try {
            ps = getConnection().prepareStatement("INSERT INTO users(username, password) VALUES('" + username + "','" + password + "');");
            ps.execute();
            System.out.println("Sign up successful!");
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean logIn() {
        System.out.println("Enter your data for log in: ");
        System.out.println("Enter the username: ");
        String username = scanner.next();
        System.out.println("Enter the password: ");
        String password = scanner.next();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM users " +
                    "WHERE username ='" + username + "'");
            rs = ps.executeQuery();

            String usernameObj, passwordObj;

            while (rs.next()) {
                usernameObj = rs.getString("username");
                passwordObj = rs.getString("password");

                if (usernameObj.equals(username) && passwordObj.equals(password)) {
                    System.out.println("Login successful!");
                    return true;
                } else if (username.equals(usernameObj) && !password.equals(passwordObj)) {
                    System.out.println("Password does not match the username. Try again.");
                    TodoListController.logIn();
                    return false;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Non existing credentials. Try again.");
        TodoListController.logIn();
        return false;
    }


    public static boolean addTask() {
        System.out.println("Enter the username: ");
        String username = scanner.next();
        System.out.println("Enter the task you want to add: ");
        String task = scanner.next();
        System.out.println("Enter the deadline of your task (format YYYY-MM-DD): ");
        String deadline = scanner.next();
        System.out.println("Enter the status of task accomplishment (yes or no): ");
        String acomp = scanner.next();

        try {
            ps = getConnection().prepareStatement("INSERT INTO todolist(username, task, deadline, acomplishment) VALUES('" + username + "', '" + task + "', DATE '" + deadline + "', '" +acomp+"');");
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;
        }
    }

    public static boolean deleteTask() {
        System.out.println("Enter the id of the task you want to delete: ");
        int taskID = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("DELETE FROM todolist WHERE id=" + taskID);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }
    }

        public static boolean editTask() {

            System.out.println("Enter the id of the task that you want to edit:");
            int taskID = scanner.nextInt();

            System.out.println("Enter what data you want to update in the table: ");
            System.out.println("1. Task name; \n" +
                    "2. Task deadline; \n" +
                    "3. Task accomplishment status; \n"+
                    "4. All of the above.");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the new name of the task: ");
                    String task = scanner.next();
                    try {
                        ps = getConnection().prepareStatement("UPDATE todolist SET task='" + task + "' WHERE id=" + taskID);
                        ps.execute();
                    } catch (SQLException e) {
                        System.out.println("Task name not updated.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the deadline for a task (format: YYYY-MM-DD): ");
                    String taskDate = scanner.next();
                    try {
                        ps = getConnection().prepareStatement("UPDATE todolist SET deadline=DATE '"+ taskDate + "' WHERE id=" + taskID);
                        ps.execute();
                    } catch (SQLException e) {
                        System.out.println("Task deadline not updated.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the task accomplishment status (yes or no): ");
                    String taskStatus = scanner.next();
                    try {
                        ps = getConnection().prepareStatement("UPDATE todolist SET acomplishment='" + taskStatus + "' WHERE id="+taskID);
                        ps.execute();
                    } catch (SQLException e) {
                        System.out.println("Task status not updated.");
                    }
                    break;
                case 4:
                    System.out.println("Enter the new name of the task: ");
                    String taskAll = scanner.next();
                    System.out.println("Enter the deadline for a task (format: YYYY-MM-DD): ");
                    String taskDateAll = scanner.next();
                    System.out.println("Enter the task accomplishment status (yes or no): ");
                    String taskStatusAll = scanner.next();
                    try {
                        ps = getConnection().prepareStatement("UPDATE todolist SET task='" + taskAll + "', deadline=DATE '"+ taskDateAll + "', acomplishment='" + taskStatusAll + "' WHERE id="+taskID);
                        ps.execute();
                    } catch (SQLException e) {
                        System.out.println("The task data is not updated.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Try again");
                    editTask();
            }
            return true;
        }
}

