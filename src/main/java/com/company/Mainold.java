package com.company;
import com.company.dbhelper.DbConnection;
import com.company.menu.StudentMenu;
import com.company.menu.BookMenu;


import java.util.Scanner;


public class Mainold {
    public static void main(String[] args) {
        // CRUD - Create, Read, Update and Delete

        // Create a table called scores and it should have 5 fields called
        // Mathematics, English, Physics and Chemistry.

        // Attempt to add 3 student's scores into the scores table.
        // HINT: USe the id of an existing student

        // Attempt to create a deleteScore() method in your Students controller
        // to delete a particular student's score by the id.



        StudentMenu.menu();
     //   DbConnection.getConnection();
       // BookMenu.menu();

        // Task :
        // Create a BookController and also Create a Book menu.
        // Using the template shown and we'll demo them.
    }
}
