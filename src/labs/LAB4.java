package labs;

import java.util.Scanner;

class COMPLEX {
    private int real, imaginary;

    COMPLEX() {
        real = 0;
        imaginary = 0;
    }

    COMPLEX(int a, int b) {
        real = a;
        imaginary = b;
    }

    public COMPLEX ADD(int a, COMPLEX s2) {

        this.real = s2.real + a;
        this.imaginary = s2.imaginary;
        return this;
    }

    public COMPLEX ADD(COMPLEX s1, COMPLEX s2) {
        this.real = s2.real + s1.real;
        this.imaginary = s2.imaginary + s1.imaginary;
        return this;
    }

    public void display() {
        System.out.println("\nThe Complex number is : " + real + " + " + imaginary + "i");
    }
}

public class LAB4 {
    public static void main(String[] args) {

        System.out.println("Complex number");
        Scanner sc = new Scanner(System.in);

        System.out.print("\nObject 1 :\nEnter real: ");
        int real = sc.nextInt();
        System.out.print("Enter imaginary : ");
        int imaginary = sc.nextInt();


        COMPLEX obj1 = new COMPLEX(real, imaginary);

        System.out.print("\nObject 2 :\nEnter real: ");
        real = sc.nextInt();
        System.out.print("Enter imaginary : ");
        imaginary = sc.nextInt();

        int a = 10; //integer

        COMPLEX obj2 = new COMPLEX(real, imaginary);

        COMPLEX obj3 = new COMPLEX(0, 0);
        obj3 = obj1.ADD(a, obj1);
        System.out.print("\nAfter adding 10 to real and imaginary part of OBJECT1 : ");
        obj3.display();

        obj2 = obj2.ADD(obj1, obj2);
        System.out.print("\nAfter adding both OBJECTS:");
        obj2.display();

    }
}