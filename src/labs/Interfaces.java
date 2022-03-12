package labs;//class A {
//    private static final int  =453;
//    String s = "AAA";
//
//
//    void methodA() {
//        System.out.println(s);
//    }
//
//    static class B {
//        void methodB() {
//            A a = new A();
//            a.s = "fff";
//            a.methodA();
//        }
//    }
//}
//

class A {


    String name = "Gautam";

    {
        System.out.print("Hello! from instantiated block we are glad to have you here, ");
    }

    public A() {
        System.out.println(name);
    }

    public A(String Name) {
        name = Name;
        System.out.println(name);
    }
}

public class Interfaces {
    static {
        System.out.println("IMPLEMENTATION OF STATIC & INSTANTIATED BLOCKS");
    }

    public static void main(String[] args) {

        new A(); //here we are invoking default constructor
        new A("Rishabh"); //invoking parameterized constructor


    }
}
