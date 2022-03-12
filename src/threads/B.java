package threads;


class B extends Thread {
    @Override
    public void run() {
        System.out.println("\nRunning from thread " + currentThread().getName());

        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");

        }
        System.out.println();
    }
}
