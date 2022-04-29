package com.company.menu;

import com.company.controllers.BookController;

import java.awt.print.Book;
import java.util.Scanner;

public class BookMenu {

    public static void menu(){
        Scanner scanner = new Scanner (System.in);

        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new book");
        System.out.println("2. Get book by id");
        System.out.println("3. Edit book name by id");
        System.out.println("4. Delete book by id");
        System.out.println("5. Edit students specific subjects score");
        System.out.println("6. Delete students score if student is deleted from database");



        System.out.println("Select and option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println(BookController.addBook() ? "Successfully added new book" : "Book not added");
                break;
            case 2:
                System.out.println(BookController.getBookById().getName());
                break;
            case 3:
                System.out.println(BookController.editBookName() ? "Book name successfully changed" : "Book name not changed");
                break;
            case 4:
                System.out.println(BookController.deleteBook() ? "Book successfully deleted" : "Book was not deleted");
                break;
            case 5:
                System.out.println();
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }
    }


}
