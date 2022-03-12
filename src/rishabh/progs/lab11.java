package rishabh.progs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 01/05/21 AT 5:27 PM
     DESCRIPTION: 
     
*/

import java.util.Scanner;

class myException extends Exception {

    public myException(String message) {
        super(message);
    }
}

public class lab11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {//try block

            System.out.print("Enter a String: ");
            String a = sc.next();//enter a
            String res[] = a.split("[&@#$]");
            String res1[] = a.split("[0-9]");

            if (res1.length != 2) {
                throw new Exception();
            } else if (res.length != 3) {
                throw new Exception();
            } else if (a.length() != 8) {
                throw new Exception();
            } else if (Character.isUpperCase(a.charAt(0)) || Character.isUpperCase(a.charAt(7))) {
                throw new Exception();
            }
            System.out.println("Valid String");

        } catch (Exception e) {

            String criteria = "PLEASE ENTER THE CORRECT STRING\n" +
                    "1.The first and last character of the string must be in small letter.\n" +
                    "\n" +
                    "2.The length of the string must be 8 characters.\n" +
                    "\n" +
                    "3.The string must have exactly two special characters and one numeric character.";
            myException exe = new myException(criteria);
            System.out.println(exe.getMessage());
        }
    }
}