package com.company.books_hw;

public class Books {

    private int id;
    private String name;
    private float price;

    public Books(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String toString (){
        return "Book ID: " + this.getId() + "; book name: " + getName()
                + "; book price: " + getPrice() + ";\n";
    }
}
