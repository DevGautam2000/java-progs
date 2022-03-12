//package threads;
//
//
//public class Main {
//
//    public static void main(String[] args) {
//
//
//        rishabh.progs.A a = new rishabh.progs.A();
//        a.setName("A");
//
//
//        rishabh.progs.B b = new rishabh.progs.B();
//        b.setPriority(Thread.MAX_PRIORITY);
//        b.setName("B");
//
//
//        rishabh.progs.C c = new rishabh.progs.C();
//        c.setName("C");
//
//        b.start();
//        try {
//            b.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        a.start();
//        try {
//            a.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        c.start();
//
//
//    }
//}
