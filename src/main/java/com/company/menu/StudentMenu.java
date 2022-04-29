package com.company.menu;

import com.company.controllers.StudentController;

import java.util.Scanner;
public class StudentMenu {

    public static void menu(){
        Scanner scanner = new Scanner (System.in);
        System.out.println("What do you want to do?: ");
        System.out.println("1. Add a new student");
        System.out.println("2. Get student by id");
        System.out.println("3. Add students scores");
        System.out.println("4. Delete students scores by id");
        System.out.println("5. Edit students specific subjects score");
//        System.out.println("6. Delete students score if student is deleted from database");

        System.out.println("Select and option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
               // StudentController.addStudent();
                System.out.println(StudentController.addStudent() ? "Successfully added new student" : "Student not added");
                break;
            case 2:
                System.out.println(StudentController.getStudentById().getName());
                break;
            case 3:
                System.out.println(StudentController.addStudentScores() ? "Students scores successfully added" : "Students scores not added");
                break;
            case 4:
                System.out.println(StudentController.deleteScore() ? "Students score successfully deleted" : "Students score was not deleted");
                break;
            case 5:
                System.out.println(StudentController.editScore()? "Students score successfully edited" : "Students score was not edited");
                break;
//            case 6:
//                System.out.println(StudentController.deleteScore(id))? "Students score successfully deleted" : "Students score was not deleted";
//                break;
            default:
                System.out.println("Invalid option. Try again");
                menu();
        }
    }
}
