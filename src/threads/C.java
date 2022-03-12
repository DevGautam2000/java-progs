package threads;


class C extends Thread {
    @Override
    public void run() {
        System.out.println("\nRunning from thread " + currentThread().getName());

        for (int i = 1; i <= 100; i++) {

            if (i == 5) {

                System.out.println();
                System.out.println(currentThread().getName() + " Stopped.");
                return;
            }
            System.out.print(i + " ");
        }
    }
}


