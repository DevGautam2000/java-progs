package rishabh.progs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 03/05/21 AT 5:33 PM
     DESCRIPTION: 
     
*/

class A extends Thread {
    @Override
    public void run() {
        System.out.println("\nRunning from thread A");


        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class B extends Thread {
    @Override
    public void run() {
        System.out.println("\nRunning from thread B");

        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");

        }
        System.out.println();
    }
}

class C extends Thread {
    @Override
    public void run() {
        System.out.println("\nRunning from thread C");

        for (int i = 1; i <= 100; i++) {

            if (i == 5) {

                System.out.println();
                System.out.println("C Stopped.");
                return;
            }
            System.out.print(i + " ");
        }
    }
}


public class lab {
    public static void main(String[] args) {


        A a = new A();

        B b = new B();
        b.setPriority(Thread.MAX_PRIORITY);

        C c = new C();

        a.start();
        b.start();
        c.start();

    }
}
