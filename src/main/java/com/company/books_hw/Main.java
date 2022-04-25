package com.company.books_hw;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Books> bookTable = new ArrayList<>();
        bookTable.add(new Books(1, "Dune", 15.39f));
        bookTable.add(new Books(2, "Eat, Pray, Love", 10.49f));
        bookTable.add(new Books(3, "Where the Crowdads Sing", 12.09f));
        bookTable.add(new Books(4, "Fangirl", 14.19f));
        bookTable.add(new Books(5, "Call Me By Your Name", 15.39f));
        
         for (int i = 0; i <bookTable.size(); i++) {
            if (Books.greaterThan()==false){
                bookTable.remove(i);
            }
        }
        System.out.println(bookTable);

    }
}
