package labs;

class Thread1 implements Runnable {//class Thread1 that implements Runnable


    @Override
    public void run() {
        System.out.println("\nRunning thread1");


        for (int i = 40; i <= 60; i = i + 2) {//loop to print from 1 to 100
            if (i >= 55) {
                System.out.println();
                System.out.println("Thread1 Stopped.");//as soon as i reaches 55 we display the message
                return;//returning from thread C
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class Thread2 implements Runnable {//class Thread2 that implements Runnable

    @Override
    public void run() {
        System.out.println("\nRunning thread2");

        for (int i = 41; i <= 60; i = i + 2) {//loop to print from odd numbers from 40 to 60
            if (i >= 55) {
                System.out.println();
                System.out.println("Thread2 Stopped.");//as soon as i reaches 55 we display the message
                return;//returning from thread C
            }
            System.out.print(i + " ");

        }
        System.out.println();
    }
}


public class ri {
    public static void main(String[] args) {//main method


        Runnable a = new Thread1();//instantiating a with thread1

        Thread obj = new Thread(a);//passing the object in thread class

        //by default the "a" is default priority that is NORM_PRIORITY
        obj.setName("TH1");//setting the name of the thread


        Runnable b = new Thread2();//instantiating a with thread1
        Thread obj1 = new Thread(b);//passing the object in thread class


        obj1.setPriority(Thread.MAX_PRIORITY);//the max priority is of thread b


        //starting the execution of threads
        obj.start();//first of thread a
        obj1.start();//second of thread b


    }
}