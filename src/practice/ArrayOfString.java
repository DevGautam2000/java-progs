package practice;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 11/05/21 AT 2:26 PM
     DESCRIPTION: 

     QUESTION:
     Write a a java program to creates menu driven program that should have following features:
     1. Input a sentence from user and create an array of string from the sentence
     2.Insert a string in an array of string by using function insert(String s, int pos) if array
     is full it should throw an exception
     3.Delete a string in an array of string by using function delete(int pos) if array does not have
      any element it should throw an exception.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfString {

    private static final Scanner GET = new Scanner(System.in);
    private static String[] strings;

    public static void main(String[] args) {


        System.out.print("\nEnter a sentence: ");
        String sentence = GET.nextLine();

        strings = sentence.split("[. ]");

        System.out.println(Arrays.toString(strings));

        while (true) {

            System.out.print("\n     MENU\n" +
                    "1.insert string in array\n" +
                    "2.delete string from array\n" +
                    "3.display array\n" +
                    "4.exit\n" +
                    "Enter choice: ");
            int CHOICE = GET.nextInt();

            switch (CHOICE) {

                case 1:
                    System.out.print("\nEnter a string: ");
                    String string = GET.next();

                    System.out.print("\nEnter a position to insert in array: ");
                    int pos = GET.nextInt();

                    insert(string, pos);
                    break;

                case 2:

                    System.out.print("\nEnter a position to delete from array: ");
                    pos = GET.nextInt();

                    try {
                        delete(pos);
                    } catch (Exception e) {
                        // do nothing
                    }
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    System.out.println("\nExited....");
                    System.exit(0);

                default:
                    System.out.println("\nInvalid Input\n");

            }
        }
    }

    private static void display() {

        if (strings.length > 0) {
            System.out.println("\n");
            System.out.println(Arrays.toString(strings));
        } else {
            System.out.println("\nArray is empty.\n");
        }
    }

    private static void delete(int pos) throws Exception {

        try {
            if (strings.length > 0) {
                ArrayList<String> dummy = new ArrayList<>(Arrays.asList(strings));
                System.out.printf("\nDeleted %s from position %d.\n", dummy.get(pos - 1), pos);
                dummy.remove(pos - 1);
                strings = dummy.toArray(new String[0]);

                System.out.printf("\nDeleted %s from position %d.\n", dummy.get(pos - 1), pos);

            } else {
                System.out.println("\nArray is empty.\n");
            }
        } catch (Exception err) {
            err = new Exception("\nThe position does not exist");
            System.out.println(err.getMessage());
        }

    }

    private static void insert(String s, int position) {

        ArrayList<String> dummy = new ArrayList<>(Arrays.asList(strings));

        if (strings.length == 0) {
            System.out.println("\nArray was empty inserted at position 1");
            dummy.add(0, s);
        } else {
            dummy.add(position - 1, s);
            System.out.println("\nInserted at position " + position);
        }
        strings = dummy.toArray(new String[0]);
    }
}
