package labs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 01/05/21 AT 3:19 PM
     DESCRIPTION: 


ALGORITHM(validateString):

Algorithm Name: EXCEPTION HANDLING
Algorithm Description: Java program to implement exception handling

VARIABLES:

Input Variables: string
Output Variables: VALID, INVALID, CRITERIA

STEPS:

0.Start
1.string := (READ)
2.string.split("[&@#$]") store in specialCharacters
3.string.split("[0-9]") store in numericValues
4.try do
5.if (numericValues.length != 2) do
6.throw EXCEPTION
7.or specialCharacters.length != 3 do
8.throw EXCEPTION
9.or string.length() != 8 do
10.throw EXCEPTION
11.or isUpperCase(string, 0) || isUpperCase(string, string.length() - 1) do
12.throw EXCEPTION
13.end if
14.Display "VALID STRING"
15.catch (Exception error) do
16.error = new CustomException("PLEASE ENTER VALID STRING")
17.Display error.getMessage()
18.end try catch
19.Stop

PSEUDOCODE: isUpperCase()
isUpperCase(String a, int pos) {
        return Character.isUpperCase(a.charAt(pos))
        }

INPUT/OUTPUT:

EXECUTION 1:

IMPLEMENTATION OF EXCEPTION HANDLING

Enter a String: g@ut@m1k
VALID STRING
___________________________________________________________________
EXECUTION 2:

IMPLEMENTATION OF EXCEPTION HANDLING

Enter a String: gautam1k

CustomException: PLEASE ENTER VALID STRING
1)The first and last character of the string must be in small letter.
2)The length of the string must be 8 characters.
3)The string must have exactly two special characters and one numeric character.

*/

import java.util.Scanner;

//custom exception
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

//main class
public class ExceptionHandling {
    private static final Scanner GET = new Scanner(System.in);
    private static final Exception EXCEPTION = new Exception();
    private static final String VALID = "VALID STRING";
    private static final String INVALID = "PLEASE ENTER VALID STRING";

    private static final String CRITERIA = "1)The first and last character of the string must be in small letter.\n" +
            "2)The length of the string must be 8 characters.\n" +
            "3)The string must have exactly two special characters and one numeric character.";

    static { //static block
        System.out.println("IMPLEMENTATION OF EXCEPTION HANDLING\n");
    }

    public static void main(String[] args) {
        validateString();
    }

    //method to validate the string according to the criteria
    private static void validateString() {
        System.out.print("Enter a String: ");
        String string = GET.next(); // read string

        String[] specialCharacters = string.split("[&@#$]"); // split if special characters found
        String[] numericValues = string.split("[0-9]"); // split if number found


        try {
            /*CHECK FOR - should contain 1 numeric value
            - should contain 2 special characters
            - string length should be 8
            - the first and last characters should be lowercase*/

            if (numericValues.length != 2 ||
                    specialCharacters.length != 3 ||
                    string.length() != 8 ||
                    (isUpperCase(string, 0) || isUpperCase(string, string.length() - 1))) {
                throw EXCEPTION; // throw exception if criteria not matched
            }
            System.out.println("\n" + VALID);

        } catch (Exception error) { //catch the exception
            error = new CustomException(INVALID);
            System.out.println("\n" + error.getMessage());
            System.out.println(CRITERIA);
        }
    }

    //method to check if a character is in Uppercase
    private static boolean isUpperCase(String a, int pos) {
        return Character.isUpperCase(a.charAt(pos));
    }
}
