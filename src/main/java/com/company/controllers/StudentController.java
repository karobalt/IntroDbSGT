package com.company.controllers;
import com.company.dbhelper.DbConnection;
import com.company.objects.Students;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.company.dbhelper.DbConnection.getConnection;


public class StudentController {
    // initialize the scanner
    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    // Add student controller
    public static boolean addStudent() {
        // Prompt the user for data
        System.out.println("Enter the name of the student: ");
        String name = scanner.next();
        System.out.println("Enter the age of the student: ");
        int age = scanner.nextInt();

        try {
            // INSERT INTO students(name, age) VALUES ('name', age)
            ps = getConnection().prepareStatement("INSERT INTO students(name, age) VALUES('" + name + "'," + age + ")");
            ps.execute(); //execute the sql command
            return true; // return true if successful
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }

    }

    //Get student by id controller
    public static Students getStudentById() {
        // Prompt the user to enter the id of the student they want to retrieve
        System.out.println("Enter the id of the student: ");
        int id = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("SELECT * FROM students WHERE id=" + id);
            rs = ps.executeQuery();

            // Define variables to temporarily hold
            // each field in the result set.

            int studentID, age;
            String name;
            // Instantiate the student object to return at the end of the method execution
            Students student = new Students();

            // Loop through the result set and add the necessary values to the student object

            while (rs.next()) {
                studentID = rs.getInt("id");
                name = rs.getString("name");
                age = rs.getInt("age");
                student.setName(name);
                student.setId(studentID);
                student.setAge(age);

            }
            return student;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addStudentScores() {
        // Prompt the user for data
        System.out.println("Enter the id of the student you want to add scores to: ");
        int id = scanner.nextInt();
        System.out.println("Enter the students score for mathematics: ");
        int mathematics = scanner.nextInt();
        System.out.println("Enter the students score for english: ");
        int english = scanner.nextInt();
        System.out.println("Enter the students score for physics: ");
        int physics = scanner.nextInt();
        System.out.println("Enter the students score for chemistry: ");
        int chemistry = scanner.nextInt();

        try {
            ps = getConnection().prepareStatement("INSERT INTO scores(studentid, mathematics, english, physics, chemistry) VALUES(" + id + "," + mathematics + "," + english + "," + physics + "," + chemistry + ")");
            ps.execute(); //execute the sql command
            return true; // return true if successful
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }

    }

    public static boolean deleteScore() {
        // Prompt the user for data
        System.out.println("Enter the id of the student whose score you want delete: ");
        int studentid = scanner.nextInt();

        try {
            // DELETE FROM student WHERE studentid = studentid;
            ps = getConnection().prepareStatement("DELETE FROM scores WHERE studentid=" + studentid);

            ps.execute(); //execute the sql command
            return true; // return true if successful
        } catch (SQLException e) {
            System.out.println("Database Error");
            return false;

        }

    }

    public static boolean editScore() {
        // Prompt the user for data
        System.out.println("Enter the id of the student, whose score you want to change: ");
        int studentid = scanner.nextInt();
        System.out.println("Enter the number of a subject whose score you want to change: ");
        System.out.println("1.Mathematics; \n" +
                "2. English; \n" +
                "3. Physics; \n" +
                "4. Chemistry.");
        int subject = scanner.nextInt();

        switch (subject) {
           case 1:
               System.out.println("Enter the score of the subject: ");
               int mathematics = scanner.nextInt();
               try {
                   ps = getConnection().prepareStatement("UPDATE scores SET mathematics=" + mathematics +" WHERE studentid="+studentid);
                   ps.execute(); //execute the sql command
               } catch (SQLException e) {
                   System.out.println("Score not updated");
               }
               break;
            case 2:
                System.out.println("Enter the score of the subject: ");
                int english = scanner.nextInt();
                try {
                    ps = getConnection().prepareStatement("UPDATE scores SET english=" + english +" WHERE studentid="+studentid);
                    ps.execute(); //execute the sql command
                } catch (SQLException e) {
                    System.out.println("Score not updated");
                }
                break;
            case 3:
                System.out.println("Enter the score of the subject: ");
                int physics = scanner.nextInt();
                try {
                    ps = getConnection().prepareStatement("UPDATE scores SET physics=" + physics +" WHERE studentid="+studentid);
                    ps.execute(); //execute the sql command
                } catch (SQLException e) {
                    System.out.println("Score not updated");
                }
                break;
            case 4:
                System.out.println("Enter the score of the subject: ");
                int chemistry = scanner.nextInt();
                try {
                    ps = getConnection().prepareStatement("UPDATE scores SET chemistry=" + chemistry +" WHERE studentid="+studentid);
                    ps.execute(); //execute the sql command
                } catch (SQLException e) {
                    System.out.println("Score not updated");
                }
                break;
            default:
                System.out.println("Invalid option. Try again");
                editScore();
        }
        return true;
    }

//    public static boolean studentExistsCheck() {
//        // Prompt the user for data
//        System.out.println("Enter the id of the student whom you want to check if he/she is still in the database: ");
//        int id = scanner.nextInt();
//
//        try {
//            ps = getConnection().prepareStatement("SELECT id FROM students WHERE id=" + id);
//
//            ps.execute(); //execute the sql command
//            return true; // return true if successful
//        } catch (SQLException e) {
//            System.out.println("Student does not exist");
//            return false;
//        }
//    }
//    public static boolean deleteScore(int studentid) {
//
//        if (studentExistsCheck() == false) {
//
//
//            try {
//                // DELETE FROM student WHERE studentid = studentid;
//                ps = getConnection().prepareStatement("DELETE FROM scores WHERE studentid=" + studentid);
//
//                ps.execute(); //execute the sql command
//            } catch (SQLException ex) {
//                System.out.println("Database Error");
//
//            }
//        }
//        return true;
//
//
//    }
}