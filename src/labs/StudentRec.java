package labs;/*

            AUTHOR: GAUTAM CHANDRA SAHA
            REG NO: 201900099
            DATE & TIME: 23/03/2021 AT 8:30 PM
            DESCRIPTION: Java program to implement inheritance and interface

  ALGORITHM:

Algorithm name: Implementation of  inheritance and interface
Algorithm description: Program in Java to define a class named Student to handle students' performance record

VARIABLES:
Input variables: name,rollNo,marks1,marks2,department
Output variables: name,rollNo,marks1,marks2,department,totalMarks

STEPS:
 0.Start.
 1.Create a class student with properties name,department,roll_no,marks1,marks2,sport_wt.
 2.Create another class Marks which Inherit Student .
    2.1.This class has two methods put_details and get_details.
    2.2.put_details: Which sets the details of an object.
    2.3.get_details: which prints the details.
 3.Than Create a interface called Sports which has sport_wt and get_sport_wt()
 4.At last create Result class which inherits Marks and implements Sports and redefine the get_details() by printing the Total_marks.
 5.Also redefine the get_sport_wt() which will return the sport_wt value.
 6.In main class:
    6.1.In main create an object of Result .
    6.2.Call the put_details to read details of an Student.
    6.3.Than call get_details which will print the details along with total marks.
 7.Stop.

INHERITANCE AND INTERFACE


STUDENT DETAILS


Enter details for Student 1:
Name: Gautam Ch Saha
Roll no: 56
Department: CSE
Marks in
Subject 1: 50
Subject 2: 46

Enter details for Student 2:
Name: Rishabh Prasad
Roll no: 54
Department: CSE
Marks in
Subject 1: 48
Subject 2: 50

Student Details:


Name: Gautam Ch Saha
Roll no: 56
Marks in
Sub 1: 50.000000	Sub 2: 46.000000
Department: CSE
Sports Weightage: 8.0
Total marks: 104.0

Name: Rishabh Prasad
Roll no: 54
Marks in
Sub 1: 48.000000	Sub 2: 50.000000
Department: CSE
Sports Weightage: 8.0
Total marks: 106.0
 */

import java.util.Scanner;

//interface to implement sport weightage
interface Sports {
    float sport_wt = 8.0f; //sports weightage

    float getSport_wt();
}

//class student to hold student record
class Student {
    private String name;
    private int rollNo;
    private float marks1, marks2;
    private String department;


    public String getName() { //getter for name
        return name;
    }

    public void setName(String name) { //setter for name
        this.name = name;
    }

    public int getRollNo() { //getter for rollNo
        return rollNo;
    }

    public void setRollNo(int rollNo) { //setter for rollNo
        this.rollNo = rollNo;
    }

    public float getMarks1() { //getter for marks1
        return marks1;
    }

    public void setMarks1(float marks1) { //setter for marks1
        this.marks1 = marks1;
    }

    public float getMarks2() {  //getter for marks2
        return marks2;
    }

    public void setMarks2(float marks2) { //setter for marks2
        this.marks2 = marks2;
    }

    public String getDepartment() { //getter for department
        return department;
    }

    public void setDepartment(String department) { //setter for department
        this.department = department;
    }
}

//class to read and write student details
//inherited from Student
class Marks extends Student {

    //method to read student details
    public void putDetails(Result obj, int studentCount) {

        Scanner get = new Scanner(System.in);

        System.out.printf("\nEnter details for Student %d:\n", studentCount);
        System.out.print("Name: ");
        String name = get.nextLine();

        System.out.print("Roll no: ");
        int rollNo = get.nextInt();

        System.out.print("Department: ");
        String department = get.next();

        System.out.print("Marks in\nSubject 1: ");
        float marks1 = get.nextFloat();
        System.out.print("Subject 2: ");
        float marks2 = get.nextFloat();

        obj.setName(name);
        obj.setRollNo(rollNo);
        obj.setMarks1(marks1);
        obj.setMarks2(marks2);
        obj.setDepartment(department);


    }

    public void getDetails() { //method to get student details
        System.out.printf("\nName: %s\n" +
                "Roll no: %d\n" +
                "Marks in\nSub 1: %f\tSub 2: %f\n" +
                "Department: %s\n", getName(), getRollNo(), getMarks1(), getMarks2(), getDepartment());
    }

}

//class result to handle total marks of a student
//inherited from Marks and implements Sports
class Result extends Marks implements Sports {


    private float totalMarks;

    public float getTotalMarks() { //getter for totalMarks
        return totalMarks;
    }

    public void setTotalMarks() { //setter for totalMarks
        this.totalMarks = getMarks1() + getMarks2() + getSport_wt();
    }


    @Override
    public void getDetails() { //overridden method to get details of a student
        super.getDetails();
        setTotalMarks();
        System.out.println("Sports Weightage: " + getSport_wt());
        System.out.println("Total marks: " + getTotalMarks());
    }

    @Override
    public float getSport_wt() {
        return sport_wt;
    }
}

public class StudentRec {
    public static void main(String[] args) {

        System.out.println("\nINHERITANCE AND INTERFACE\n");
        System.out.println("\nSTUDENT DETAILS\n");

        int stuCount = 0;

        Result getResultsOfStudent1 = new Result(); //student 1
        getResultsOfStudent1.putDetails(getResultsOfStudent1, (++stuCount));

        Result getResultsOfStudent2 = new Result(); //student 2
        getResultsOfStudent2.putDetails(getResultsOfStudent2, (++stuCount));

        //display details of students
        System.out.println("\nStudent Details: \n");
        getResultsOfStudent1.getDetails();
        getResultsOfStudent2.getDetails();


    }
}
