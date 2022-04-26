package com.company;

import com.company.objects.Books;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Books> bookTable = new ArrayList<>();
        bookTable.add(new Books(1, "Dune", 15));
        bookTable.add(new Books(2, "Eat, Pray, Love", 10));
        bookTable.add(new Books(3, "Where the Crowdads Sing", 12));
        bookTable.add(new Books(4, "Fangirl", 14));
        bookTable.add(new Books(5, "Call Me By Your Name", 15));

        System.out.println(filterLessThanTen(bookTable));

    }

    public static List<String> filterLessThanTen(List<Books> books) {
        List<String> bookNames = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getPrice() < 10) books.remove(books.get(i));}

        books.forEach(Books -> bookNames.add(Books.getName()));

        return bookNames;

    }
}

