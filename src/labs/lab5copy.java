package labs;

import java.util.Scanner;

class lab5copy {

    private String name;
    private int reg_no;
    private char sec;

    lab5copy() {

        this.name = "Rahul";
        this.reg_no = 20194568;
        this.sec = 'A';

    }

    //parameterized constructor
    lab5copy(String name, int reg_no, char sec) {

        this.name = name;
        this.reg_no = reg_no;
        this.sec = sec;
    }

    public static void main(String[] args) {


        Scanner get = new Scanner(System.in);
        System.out.println("IMPLEMENTATION OF ARRAY OF OBJECTS.\n\n_______________________________\n");

        lab5copy[] student = new lab5copy[5];


        student[0] = new lab5copy(); //default constructor


        for (int i = 1; i <= 2; i++) {

            System.out.printf("For student %d:\nEnter name: ", i);
            String name = get.next();
            System.out.print("\nEnter reg no: ");
            int reg_no = get.nextInt();
            System.out.print("\nEnter section: ");
            char sec = get.next().charAt(0);

            student[i] = new lab5copy(name, reg_no, sec);
        }

        System.out.println("STUDENT DETAILS\n\n____________");

        System.out.println("Instantiated using default constructor\n");
        student[0].display();

        System.out.println("Instantiated using parameterized constructor\n");

        for (int i = 1; i <= 2; i++) {

            student[i].display();

        }
    }

    void display() {

        System.out.printf("Name: %s\nReg. no: %d\nSection: %c\n____________", name, reg_no, sec);
        System.out.println();
    }
}