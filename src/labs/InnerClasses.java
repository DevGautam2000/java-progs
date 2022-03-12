package labs;

class Outer {
    static class InnerStatic {
        int staticInVar;
    }

    static class AnotherInner {
        static int totalStaticVar;
    }

    class InnerNotStatic {
        int innerVar;
    }
}

public class InnerClasses {
    public static void main(String[] args) {


        //accessing the var in non static inner class
        Outer out = new Outer();
        Outer.InnerNotStatic in = out.new InnerNotStatic();
        int var = in.innerVar = 10;

        //accessing the var in static inner class
        Outer.InnerStatic anotherIn = new Outer.InnerStatic();
        int var2 = anotherIn.staticInVar = 45;

        //accessing the static var in static inner class
        int var3 = Outer.AnotherInner.totalStaticVar = 70;

        System.out.println(var);
        System.out.println(var2);
        System.out.println(var3);
    }
}
