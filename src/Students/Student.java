package Students;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 08/04/21 AT 12:21 PM
     DESCRIPTION: Java program to implement packages


INPUT/OUTPUT:

IMPLEMENTATION OF IMPORTING A PACKAGE

Student {
 Name: Gautam Chandra Saha,
 Reg No: 201900099,
 Section: A,
 Dept: CSE,
 Sem: 4,
 Total subjects: 8}

Student {
 Name: Dipen Chandra Saha,
 Reg No: 202100055,
 Section: H,
 Dept: CSE,
 Sem: 1,
 Total subjects: 7}

*/


import engineering.Departments; // importing the user defined package

//Student extends Departments
public class Student extends Departments {

    static { //static block
        System.out.println("\nIMPLEMENTATION OF IMPORTING A PACKAGE\n");
    }

    private final String name;
    private final int regNo;
    private final char section;

    //    constructor
    public Student(String department, int sem, int totalSubjects, String name, int regNo, char section) {
        super(department, sem, totalSubjects);
        this.name = name;
        this.regNo = regNo;
        this.section = section;
    }

    public static void main(String[] args) {

        //instantiation of objects
        Student gautam = new Student("CSE", 4, 8,
                "Gautam Chandra Saha", 201900099, 'A');

        Student dipen = new Student("CSE", 1, 7,
                "Dipen Chandra Saha", 202100055, 'H');

        //display details of objects
        System.out.println(gautam);
        System.out.println(dipen);
    }

    //Overriding the toString() to display student details
    @Override
    public String toString() {
        return "Student {\n" +
                " Name: " + name +
                ",\n Reg No: " + regNo +
                ",\n Section: " + section +
                ",\n Dept: " + getDepartment() +
                ",\n Sem: " + getSem() +
                ",\n Total subjects: " + getTotalSubjects() +
                "}\n";
    }
}
