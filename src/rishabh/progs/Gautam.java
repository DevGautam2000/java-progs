package rishabh.progs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 01/05/21 AT 5:41 PM
     DESCRIPTION: 
     
*/

public class Gautam {

    int age;

    public Gautam(int age) {
        this.age = age;
    }

    public static void main(String[] args) {

        Gautam g = new Gautam(21);
        System.out.println(g);

    }

    @Override
    public String toString() {
        return "Gautam{" +
                "age=" + age +
                '}';
    }
}
