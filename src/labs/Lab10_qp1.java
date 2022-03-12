package labs;/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 17/04/21 AT 4:54 PM
     DESCRIPTION: 

ALGORITHM(Sort sentences in paragraph in increasing number of word count):

Algorithm Name: Implementation of string handling
Algorithm Description: Java program to sort sentences in paragraph in increasing number of word count

VARIABLES:

Input variables: choice,paragraph
Output variables: entry.getKey(),entry.getValue() //entry in sentenceList

STEPS:
0.Start
1.String paragraph := (input)
2.if paragraph.isEmpty() do
3.exit
4.end if
5.sentences := paragraph.split("[.?!]") //using regular expression to split paragraph into sentences
6.for i from 0 to (capacity and strings.length-1) do
7.sentenceMap.put(strings[i].trim(), new StringTokenizer(strings[i]).countTokens())
  //sentenceMap.put("sentence","word count")
  //StringTokenizer to count words in sentence
8.end loop
9.sentenceList = new LinkedList<>(sentenceMap.entrySet())
10.sentenceList.sort(Map.Entry.comparingByValue());// sort the list by values
11.print the sorted list
12.Stop

INPUT/OUTPUT:

IMPLEMENTATION OF STRING HANDLING
FIND WORDS IN A SENTENCE FOR A PARAGRAPH

1.Enter a paragraph.
2.Computer generated paragraph.
Enter choice: 1
Is SMIT ranked second in north east? I just heard it from somewhere. By the way I am excited to join my new college! Let's see.

Sentences in increasing number of words are:

1) Let's see--> 2 words
2) I just heard it from somewhere--> 6 words
3) Is SMIT ranked second in north east--> 7 words
4) By the way I am excited to join my new college--> 11 words
*/

import java.util.*;

public class Lab10_qp1 {
    static Scanner get = new Scanner(System.in);

    static { //static block
        System.out.println("IMPLEMENTATION OF STRING HANDLING\n" +
                "FIND WORDS IN A SENTENCE FOR A PARAGRAPH");
    }

    public static void main(String[] args) {

        //a paragraph containing more than 10 sentences
        String paragraph = "Arjit Singh is a famous Indian singer, composer, musician, recordist, music producer, and music programmer. " +
                "Do we love him? " +
                "Yes, for sure! " +
                "He sings mostly in Hindi and Bengali languages, though has also performed in numerous other Indian languages. " +
                "Arjit Singh is considered amongst one of the most successful and versatile singers in Indian music history and Bollywood cinema. " +
                "He made his career step forward once he took part in a modern reality show titled Fame Gurukul in the year 2005. " +
                "He was exposed by film directors Kumar Taurani and Sanjay Leela Bhansali." +
                "At the beginning of his career in singing, Arjit Singh received nominations for Uprising Male Vocalist of the Year.  " +
                "Also got award at Mirchi Music Awards for performances of 'Duaa' and 'Phir Le Aya Dil'. " +
                "Arjit Singh received immense recognition after the release of 'Chahun Main Ya Naa' and 'Tum Hi Ho' in the year 2013." +
                "He was born in Jiaganj Azimganj, India on 25th April, 1987. " +
                "Arjit Singh was born to a Bengali mother and Punjabi father. " +
                "He started his training in music at a very young age. " +
                "His parental aunt trained in classical music, whereas his maternal grandma used to sing. " +
                "His parental uncle played tabla, and his Mom also sang songs and played tabla. " +
                "Arjit Singh studied at Raja Bijay Singh High School and after that at Sripat Singh College. " +
                "As stated by him he 'was a decent and hardworking student, but inclined towards music' and his parents trained him under a professional manner. ";


        //gui
        System.out.print("\n1.Enter a paragraph.\n2.Computer generated paragraph.\nEnter choice: ");
        int choice = get.nextInt(); // get user input
        if (choice == 1) {
            paragraph = new Scanner(System.in).nextLine();
        } else if (choice > 2 || choice == 0) {
            System.out.println("\nInvalid input");
            System.exit(0);
        }
        if (paragraph.isEmpty()) {
            System.out.println("\nNot a paragraph");
            System.exit(0);
        }

        // map to store the sentences along with the word count
        LinkedHashMap<String, Integer> sentenceMap = new LinkedHashMap<>();
        int capacity = 10; //capacity of para(ATQ, 10 here)
        String[] sentences = paragraph.split("[.?!]+"); //split the paragraph if literals are "." or "?" or "!"

        putInMap(sentenceMap, capacity, sentences); //put in map
        List<Map.Entry<String, Integer>> sentenceList = getEntriesSortedByValues(sentenceMap);//get list sorted by values
        //display the sentences in increasing order of word count
        System.out.println("\nSentences in increasing number of words are:\n");
        printList(sentenceList);

    }

    //method to print the list sorted
    private static void printList(List<Map.Entry<String, Integer>> sentenceList) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : sentenceList) {
            System.out.println(++count + ") " + entry.getKey() + "--> " + entry.getValue() + " words");
        }
    }

    //method to get the values in list sorted by values
    private static List<Map.Entry<String, Integer>> getEntriesSortedByValues(LinkedHashMap<String, Integer> sentenceMap) {
        //use a list of <T>, where T is of type Entry
        //this list contains the entry set from the sentenceMap
        List<Map.Entry<String, Integer>> sentenceList = new LinkedList<>(sentenceMap.entrySet());
        sentenceList.sort(Map.Entry.comparingByValue());// sort the list by values(word count here for each sentence)
        return sentenceList;
    }

    //method to put the sentences in map along with word count
    private static void putInMap(LinkedHashMap<String, Integer> sentenceMap, int capacity, String[] sentence) {
        //put the sentences that are split ,to the map along with word count
        for (int i = 0; i < capacity && i < sentence.length; i++) {
            sentenceMap.put(sentence[i].trim(), new StringTokenizer(sentence[i]).countTokens());
        }
    }

}
