package labs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 15/04/21 AT 11:09 PM
     DESCRIPTION:

ALGORITHM:

Algorithm Name: Implementation of string and string buffer classes and its methods
Algorithm Description: Java program to implement string and string buffer classes

VARIABLES:

Input variables: none
Output variables: firstWord,lastWord,modified,sentenceDummy

STEPS:
0.Start
1.sentence := (input)
2.sentence.replaceAll(" ", "") //replaces all " " with ""
3.new StringBuffer(sentence)
4.stringBuffer.capacity() //returns the capacity of the string buffer
5.stringBuffer.length()//returns the length of the string buffer
6.stringBuffer.substring(0, stringBuffer.indexOf(" ") - 1)
 //substring() returns the string specified in a range
 //indexOf() returns the index of first occurrence of the searched string
7.stringBuffer.lastIndexOf(" ") //returns index of the last occurrence of the searched string
8.stringBuffer.reverse() //return a reference to the string passed but after reversing it
9.stringBuffer.toString() // returns a String if the reference passed if of Class type
10.stringBuffer.insert(3,"Lab") // inserts a String to a String variable after specified offset
11.stringBuffer.trim() //returns a reference after removing the space from beginning and end of the string
12.stringBuffer.append("string") //appends specified string to a String
13.stringBuffer.appendCodePoint(65) //appends character to string after changing from specified ASCII value
14.stringBuffer.deleteCharAt(pos)// returns string after removing the character from specified index
14.stringBuffer.delete(start, end)// returns string after removing the characterSequence from specified index range
15.Stop

INPUT/OUTPUT:

IMPLEMENTATION OF STRING & STRING-BUFFER CLASS AND IT'S METHODS

The sentence is:

GitHub, Inc. is a provider of Internet hosting for
software development and version control using Git.

1) Capacity of stringBuffer: 103

2) Length of sentence: 87

3) First word of sentence: GitHub

4) Last word of sentence: Git

5) Last word reversed: tiG

6) GitHub replaced to: Git

7) Lab inserted to Git: GitLab

8) 'is a VCS' appended to GitLab: GitLab is a VCS

9) 'Code Point 66' appended to GitHu: GitHuB

10) Last character deleted from GitHuB: GitHu

11) Sub string 'Hu' deleted from GitHu: Git

*/

public class Lab10_qp2 {
    static {
        System.out.println("IMPLEMENTATION OF STRING & STRING-BUFFER CLASS AND IT'S METHODS\n");
    }

    public static void main(String[] args) {

        String sentence = "GitHub, Inc. is a provider of Internet hosting for software development and version control using Git.";
        String sentenceDummy = "GitHub, Inc. is a provider of Internet hosting for \n" +
                "software development and version control using Git.";

        System.out.println("The sentence is: \n\n" + sentenceDummy);
        sentenceDummy = sentence;

        //using the replaceAll() method
        sentenceDummy = sentenceDummy.replaceAll(" ", "");
        StringBuffer stringBuffer = new StringBuffer(sentenceDummy);

        //using the capacity() method
        System.out.println("\n1) Capacity of stringBuffer: " + stringBuffer.capacity());

        //using the length() method
        System.out.println("\n2) Length of sentence: " + stringBuffer.length());

        stringBuffer = new StringBuffer(sentence);
        //using the subString() & indexOf() method
        String firstWord = stringBuffer.substring(0, stringBuffer.indexOf(" ") - 1);
        System.out.println("\n3) First word of sentence: " + firstWord);

        //using the subString() & lastIndexOf() method
        String lastWord = stringBuffer.substring(stringBuffer.lastIndexOf(" ") + 1, stringBuffer.length() - 1);
        System.out.println("\n4) Last word of sentence: " + lastWord);

        //using the reverse() method
        stringBuffer = new StringBuffer(lastWord);
        System.out.println("\n5) Last word reversed: " + stringBuffer.reverse());

        //using the replace() method of StringBuffer class
        stringBuffer = new StringBuffer(firstWord);
        System.out.print("\n6) " + firstWord + " replaced to: ");
        firstWord = stringBuffer.replace(3, stringBuffer.length(), "").toString();
        System.out.println(firstWord);

        //using the insert() method
        String modified = "Lab";
        System.out.print("\n7) " + modified + " inserted to " + firstWord + ": ");
        firstWord = stringBuffer.insert(3, "Lab").toString();
        System.out.println(firstWord);

        //using the append() method
        modified = " is a VCS";
        System.out.print("\n8) " + "'" + modified.trim() + "'" + " appended to " + firstWord + ": ");
        firstWord = stringBuffer.append(modified).toString();
        System.out.println(firstWord);

        //using the appendCodePoint() method
        firstWord = "GitHu";
        stringBuffer = new StringBuffer(firstWord);
        System.out.print("\n9) " + "'" + "Code Point 66" + "'" + " appended to " + firstWord + ": ");
        firstWord = stringBuffer.appendCodePoint(66).toString(); //e.g., ASCII for 65 is A
        System.out.println(firstWord);

        //using the deleteCharAt() method
        System.out.print("\n10) Last character deleted from " + firstWord + ": ");
        firstWord = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
        System.out.println(firstWord);


        //using the delete() method
        System.out.print("\n11) Sub string 'Hu' deleted from " + firstWord + ": ");
        firstWord = stringBuffer.delete(3, stringBuffer.length()).toString();
        System.out.println(firstWord);


    }
}
