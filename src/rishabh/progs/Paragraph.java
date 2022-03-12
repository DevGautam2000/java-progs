package rishabh.progs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 15/04/21 AT 4:51 PM
     DESCRIPTION: 
     
*/


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Paragraph {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a paragraph of text: ");   // Read String From User
        String str = sc.nextLine();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);   // charAt(i) : returns character at i index

            if (ch == '.' || ch == '?' || ch == '!')
                count++;
        }

        if (count > 10) {
            System.out.println("Maximum 10 sentences allowed.");
            return;
        }

        String s[] = new String[count];   //Declare String Array s[] and Frequency Array freq[] of Size Count
        int freq[] = new int[count];

        int k = 0;
        for (int i = 1; i <= count; i++) {
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '.' || ch == '?' || ch == '!')   // if . ? ! is encountered then copy the SubString into S[]
                {
                    s[k] = str.substring(0, str.indexOf(ch));  // p.indexOf(ch) returns index of ch in p
                    freq[k] = frequency(s[k]);   // frequency() : function that return word count
                    str = str.substring(str.indexOf(ch) + 1);   // now main string p starts from next character after . ? !
                    k++;   // increment k
                    break;
                }
            }
        }

        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq.length - 1 - i; j++) {
                if (freq[j] > freq[j + 1])   // check the freq[] array and arrange the in increasing order along with s[]
                {                           // so that we get string in increasing order of their words
                    int temp1 = freq[j];
                    freq[j] = freq[j + 1];   // for arranging freq[]
                    freq[j + 1] = temp1;

                    String temp2 = s[j];
                    s[j] = s[j + 1];   // for arranging s[]
                    s[j + 1] = temp2;
                }
            }
        }

        System.out.println("The Sentences are : ");
        Arrays.sort(s);
        for (int i = 0; i < freq.length; i++) {
            System.out.println(s[i]);
        }
    }

    public static int frequency(String s)   // user defined function frewuency to count number of words in an string
    {
        int count = 0;

        if (s.length() > 0)
            count = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ')   // check if white space in encountered if yes increase count
                count++;
        }
        return count;
    }

}