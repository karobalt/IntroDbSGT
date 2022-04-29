package com.company.objects;

public class Books {

    private int id;
    private String name;
    private int price;

    public Books(){}
    public Books(int id, String name, int price) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public String toString (){
//        return "Book ID: " + this.getId() + "; book name: " + getName()
//                + "; book price: " + getPrice() + ";\n";
//    }
}
