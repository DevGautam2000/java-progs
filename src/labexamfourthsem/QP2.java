package labexamfourthsem;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 06/05/21 AT 9:33 AM
     DESCRIPTION:

     QP2
     NAME: GAUTAM CHANDRA SAHA
     REG NO: 201900099

ALGORITHM:

Algorithm name: Implementation of interface
Algorithm description: Program in Java to if food for a country is healthy or not

VARIABLES:
Input variables: vitamin, mineral, fats, protein, carbohydrate
Output variables: none

STEPS:

0.Start and declare a Stack to implement
1.set the size of the stack by user input
2.enter a string to push to the stack
3.create a MENU for stack operations
4.input choice
5.switch choice do
6.case 1 do invoke isFullOrEmpty()  // to check capacity of stack
7.case 2 do  invoke pushInStack() // to push into stack
8.case 3 do invoke popFromStack() //to pop from stack
9.case 4 do invoke display() //to display the stack
10.case 5 do invoke exitProg() // to exit the program
11.case 6 do display "Invalid Input" //if invalid choice
12.Stop

PSEUDOCODE:enterChoice() {

        try do {
            //get choice
        } catch exception do {
            err.getMessage() //print error message
            exitProg() // exit program
        }
    }

PSEUDOCODE:enterString() {

        try do {
            STRING = GET.next(); //enter a string

            if (STRING.length() <= SIZE) do{
                for i = 0 to STRING.length() do {
                    characterStack.push(STRING.charAt(i));
                }
            } else do {
                display Size of string exceeds size of Stack
                exitProg() // exit program
            }
        } catch exception do {
            err.getMessage() //print error message
            exitProg() // exit program
        }
    }

PSEUDOCODE:setSize() {

        try do{
            SIZE = GET.nextInt(); //size of stack

        } catch exception do {
            err.getMessage() //print error message
            exitProg() // exit program
        }


INPUT/OUTPUT:

IMPLEMENTATION OF STACK USING STRING/STRING BUFFER


Enter size of Stack: 4

Enter a string: gaut

    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 1

Stack is full


    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 2

Stack is full


    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 3

popped t from stack


    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 4

STACK: g a u


    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 2

Enter character: m

m pushed to stack


    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 4

STACK: g a u m


    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 8

Invalid Input


    MENU

1.Check if Stack is full
2.Push
3.Pop
4.Display
5.Exit.
Enter choice: 5

Exited.


*/

import java.util.Scanner;
import java.util.Stack;


//main class
public class QP2 {

    //declare variables
    private static final Scanner GET = new Scanner(System.in);
    private static int CHOICE;
    private static int SIZE;
    private static String STRING;

    static { //static block
        System.out.println("IMPLEMENTATION OF STACK USING STRING/STRING BUFFER\n");
    }

    public static void main(String[] args) {


        //the stack to store characters
        Stack<Character> characterStack = new Stack<>();

        setSize(); //set the size of the stack
        enterString(characterStack); //enter a string whose characters to be pushed into stack

        while (true) { //infinite loop stops with exit

            //MENU
            System.out.println("\n    MENU\n\n" +
                    "1.Check if Stack is full\n" +
                    "2.Push\n" +
                    "3.Pop\n" +
                    "4.Display\n" +
                    "5.Exit.");

            enterChoice(); //get choice
            switchTask(characterStack); //perform according to choice entered
        }
    }

    //method to switch choices
    private static void switchTask(Stack<Character> characterStack) {
        switch (CHOICE) {

            case 1: //to check capacity of stack
                isFullOrEmpty(characterStack);
                break;

            case 2: //to push into stack
                pushInStack(characterStack);
                break;

            case 3: //to pop from stack
                popFromStack(characterStack);
                break;

            case 4: //to display the stack
                display(characterStack);
                break;

            case 5: // to exit the program
                exitProg();
                break;

            default: //if invalid choice
                System.out.println("\nInvalid Input\n");
                break;
        }
    }

    //method to get choice from MENU
    private static void enterChoice() {
        System.out.print("Enter choice: ");
        try { //handle exception
            CHOICE = GET.nextInt();
        } catch (Exception err) {
            err = new Exception("\nEnter from (1-5).\n");
            System.out.println(err.getMessage()); //print error message
            exitProg(); //exit program
        }
    }

    //method to enter string
    private static void enterString(Stack<Character> characterStack) {
        System.out.print("\nEnter a string: ");
        try { //handle exception
            STRING = GET.next(); //get the string

            if (STRING.length() <= SIZE) { //get for string length <= stack size
                for (int i = 0; i < STRING.length(); i++) { //push characters from string into stack
                    characterStack.push(STRING.charAt(i));
                }
            } else {
                System.out.println("\nSize of string exceeds size of Stack\n");
                exitProg();
            }
        } catch (Exception err) {
            err = new Exception("\nEnter a string.\n");
            System.out.println(err.getMessage()); //print error message
            exitProg(); //exit program
        }
    }

    //method to set the stack size
    private static void setSize() {
        System.out.print("\nEnter size of Stack: ");
        try { //handle exception
            SIZE = GET.nextInt();

        } catch (Exception err) {
            err = new Exception("\nEnter an integer.\n");
            System.out.println(err.getMessage());
            exitProg();
        }
    }

    //method to display the stack
    private static void display(Stack<Character> stack) {

        if (stack.isEmpty()) { //check if empty
            System.out.println("\nStack is empty\n");
        } else {
            System.out.print("\nSTACK: ");
            for (Character ch : stack) {
                System.out.print(ch + " ");
            }
            System.out.println("\n");
        }


    }

    //method to exit the program
    private static void exitProg() {

        System.out.println("\nExited.\n");
        System.exit(0);
    }

    //method to pop from the stack
    private static void popFromStack(Stack<Character> stack) {

        if (stack.isEmpty()) { //check if empty
            System.out.println("\nStack is empty\n");
        } else {
            System.out.println("\npopped " + stack.peek() + " from stack\n");
            stack.pop(); //pop from stack

        }
    }

    //method to push into stack
    private static void pushInStack(Stack<Character> stack) {

        if (stack.isEmpty()) {//check if empty
            System.out.println("\nStack is empty\n");
        } else if (stack.size() == SIZE) {
            System.out.println("\nStack is full\n");
        } else {
            System.out.print("\nEnter character: ");
            Character character = GET.next().charAt(0);
            stack.push(character); //push into stack
            System.out.println("\n" + character + " pushed to stack\n");
        }
    }

    //method to check capacity of stack
    private static void isFullOrEmpty(Stack<Character> stack) {

        if (stack.isEmpty()) {
            System.out.println("\nStack is empty\n");
        } else if (stack.size() == SIZE) {
            System.out.println("\nStack is full\n");
        } else {
            System.out.println("\nCapacity of stack: " + stack.size() + "/" + SIZE + "\n");
        }
    }
}

