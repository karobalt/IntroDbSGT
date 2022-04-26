package com.company.controllers;

import com.company.objects.Books;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.dbhelper.DbConnection.getConnection;

public class BookController {

    // initialize the scanner
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    // Add book controller
    public static boolean addBook() {
        // Prompt the user for data
        System.out.println("Enter the name of the book: ");
        String name = scanner.nextLine();

        System.out.println("Enter the price of the book: ");
        int price = scanner.nextInt();

        try {
            // INSERT INTO Books(name, price) VALUES ('name', price)
            ps = getConnection().prepareStatement("INSERT INTO Books(name, price) VALUES('" + name + "'," + price + ")");

            ps.execute(); //execute the sql command
            return true; // return true if successful
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }

    }

    //Get book by id controller
    public static Books getBookById() {
        // Prompt the user to enter the id of the book
        // they want to retrieve

        System.out.println("Enter the id of the book: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM Books WHERE id=" + id);
            rs = ps.executeQuery();

            // Define variables to temporarily hold
            // each field in the result set.

            int bookID, price;
            String name;

            // Instantiate the book object to return
            // at the end of the method execution

            Books book = new Books();

            // Loop through the result set and
            // add the necessary values to the book object

            while(rs.next()) {
                bookID=rs.getInt("id");
                name= rs.getString ("name");
                price = rs.getInt("price");
                book.setName(name);
                book.setId(bookID);
                book.setPrice(price);

            }
            return book;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean editBookName() {
        // Prompt the user for data
        System.out.println("Enter the id of the book you want to change: ");
        int id = scanner.nextInt();

        System.out.println("Enter the name of the book you want to change: ");
        String name = scanner.nextLine();

        try {
            // UPDATE Books set name = 'name' where id = id;
            ps = getConnection().prepareStatement("UPDATE Books SET name ='" + name + "' WHERE id=" + id);

            ps.execute(); //execute the sql command
            return true; // return true if successful
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }

    }

    public static boolean deleteBook() {
        // Prompt the user for data
        System.out.println("Enter the id of the book you want delete: ");
        int id = scanner.nextInt();

        try {
            // DELETE FROM Books WHERE id = id;
            ps = getConnection().prepareStatement("DELETE FROM Books WHERE id=" + id);

            ps.execute(); //execute the sql command
            return true; // return true if successful
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }

    }


}
