package labs;/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 06/04/21 AT 12:20 PM
     DESCRIPTION: 
     
*/

interface Shape {
    void one();
}

interface Dimension {
    void one();

    void two();
}

class Circle implements Shape, Dimension {
    @Override
    public void one() {
        System.out.println("From Circle");
    }

    @Override
    public void two() {
        System.out.println("From Circle");
    }


}

class Rect implements Shape, Dimension {
    @Override
    public void one() {
        System.out.println("From Rectangle");
    }


    @Override
    public void two() {
        System.out.println("From Rectangle");
    }


}

public class New {
    public static void main(String[] args) {

        Shape s = new Circle();
        s.one();

        Dimension d = new Circle();
        d.two();

        s = new Rect();
        s.one();
        d = new Rect();
        d.one();
        d.two();


    }
}
