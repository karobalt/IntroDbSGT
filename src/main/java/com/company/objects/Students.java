package com.company.objects;

public class Students {

    // Define the properties of the Student Object

    private int id;
    private String name;
    private int age;


    public Students(){}
    // Define constructor
    public Students(int id, String name, int age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
