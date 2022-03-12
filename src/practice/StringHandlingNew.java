package practice;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 16/04/21 AT 5:51 PM
     DESCRIPTION: 

INPUT/OUTPUT:

IMPLEMENTATION OF STRING HANDLING


1.Enter a paragraph.
2.Computer generated paragraph.
Enter choice: 2

Sentences in increasing number of words are:

1) Yes, for sure--> 3 words
2) Do we love him--> 4 words
3) He was exposed by film directors Kumar Taurani and Sanjay Leela Bhansali--> 12 words
4) Arjit Singh is a famous Indian singer, composer, musician, recordist, music producer, and music programmer--> 15 words
5) Also got award at Mirchi Music Awards for performances of 'Duaa' and 'Phir Le Aya Dil'--> 16 words
6) He sings mostly in Hindi and Bengali languages, though has also performed in numerous other Indian languages--> 17 words
7) At the beginning of his career in singing, Arjit Singh received nominations for Uprising Male Vocalist of the Year--> 19 words
8) Arjit Singh is considered amongst one of the most successful and versatile singers in Indian music history and Bollywood cinema--> 20 words
9) Arjit Singh received immense recognition after the release of 'Chahun Main Ya Naa' and 'Tum Hi Ho' in the year 2013--> 21 words
10) He made his career step forward once he took part in a modern reality show titled Fame Gurukul in the year 2005--> 22 wordss
*/

import java.util.*;

public class StringHandlingNew {
    static Scanner get = new Scanner(System.in);

    static {
        System.out.println("IMPLEMENTATION OF STRING HANDLING\n");
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


        System.out.print("\n1.Enter a paragraph.\n2.Computer generated paragraph.\nEnter choice: ");
        int choice = get.nextInt();
        if (choice == 1) {
            paragraph = new Scanner(System.in).nextLine();
        }

        //split string if literal is ".", "?" or "!"
        String[] sentence = paragraph.split("[.?!]");

        Map<String, Integer> sentences = new LinkedHashMap<>();
        int capacityOfParagraph = 10;

        int countCapacity = 0;
        for (String s : sentence) {
            if (countCapacity == capacityOfParagraph) break; //optimizes loop if capacity reached
            if (countCapacity++ < capacityOfParagraph) { //check for capacity of paragraph
                sentences.put(s.trim(), new StringTokenizer(s).countTokens());
            }
        }
        sortMapByValue(sentences); //sort the map ny value(words here)
        System.out.println("\nSentences in increasing number of words are:\n");
        printMap(sentences);
    }

    //method to print the map
    private static void printMap(Map<String, Integer> sentences) {
        int count;
        count = 0;
        for (Map.Entry<String, Integer> entry :
                sentences.entrySet()) {
            System.out.println((++count) + ") " + entry.getKey() + "--> " + entry.getValue() + " words");
        }
    }

    //    function to sort the map comparing by key
    private static void sortMapByValue(Map<String, Integer> sentences) {
        LinkedList<Map.Entry<String, Integer>> sentenceList = new LinkedList<>(sentences.entrySet());
        sentenceList.sort(Map.Entry.comparingByValue()); //sort the map by value
        sentences.clear();

        // get entry from list to the map
        for (Map.Entry<String, Integer> entry : sentenceList) {
            sentences.put(entry.getKey(), entry.getValue());
        }
    }
}

