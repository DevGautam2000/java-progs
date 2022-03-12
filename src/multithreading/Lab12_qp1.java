package multithreading;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 03/05/21 AT 11:35 AM
     DESCRIPTION: java program to implement multithreading by extending the class Thread

ALGORITHM:

Algorithm Name: Implementation of Multithreading
Algorithm Description: Java program to implement multithreading by extending the class Thread

VARIABLE:

Input Variable: none
Output Variable: i (number as counter)

STEPS:
0.Start
1.Create three classes A,B,C that extends Thread
2.In each class override the run() method to display number from 1 till 100
3.Thread C must be stopped if number is >= 5
4.Set names for each thread
5.Instantiate class A,B,C by creating object for each
6.Set names for each thread
7.Set the priority of thread B as maximum
8.Invoke the start() method of each thread
9.Stop.

INPUT/OUTPUT:

IMPLEMENTATION OF MULTITHREADING


Running from thread A

Running from thread B

Running from thread C
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42
43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64
65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86
87 88 89 90 91 92 93 94 95 96 97 98 99 100

1 2 3 4
C Stopped.
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42
43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64
65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86
87 88 89 90 91 92 93 94 95 96 97 98 99 100
*/


class A extends Thread {
    @Override
    public void run() { //override the run method
        System.out.println("\nRunning from thread " + currentThread().getName());
        Lab12_qp1.printNumbers(); //print numbers
    }
}

class B extends Thread {
    @Override
    public void run() {//override the run method
        System.out.println("\nRunning from thread " + currentThread().getName());
        Lab12_qp1.printNumbers(); //print numbers
    }
}

class C extends Thread {

    private static Boolean EXIT = false;

    public void stopThread() { //method to stop the thread
        EXIT = true;
    }

    @Override
    public void run() {//override the run method
        System.out.println("\nRunning from thread " + currentThread().getName());
        printNumbers(); //print numbers
    }

    //method to print numbers from 1 till 100
    private void printNumbers() {
        for (int i = 1; i <= 100 && !EXIT; i++) { //print from 1-100


            if (i >= 5) { // number >= 5
                System.out.println();
                System.out.println(currentThread().getName() + " Stopped.");
                stopThread(); //stop the thread
            } else {
                System.out.print(i + " ");
            }

        }
    }
}

//Main
public class Lab12_qp1 {

    static { //static block
        System.out.println("IMPLEMENTATION OF MULTITHREADING\n");
    }

    //method to print numbers from 1 till 100
    public static void printNumbers() {
        int count = 1;
        for (int i = 1; i <= 100; i++) {//print from 1-100

            if (count++ > 20) {
                System.out.println();
                count = 0;
            }
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {


        A a = new A(); //instantiate class object
        a.setName("A"); //set name of thread

        B b = new B(); //instantiate class object
        b.setPriority(Thread.MAX_PRIORITY);
        b.setName("B");//set name of thread

        C c = new C(); //instantiate class object
        c.setName("C"); //set name of thread


        a.start(); //start the thread A
        b.start(); //start the thread B
        c.start(); //start the thread C


    }

}
