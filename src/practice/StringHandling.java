package practice;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 15/04/21 AT 1:16 PM
     DESCRIPTION: 
     
*/

import java.util.*;

public class StringHandling {
    static {
        System.out.println("IMPLEMENTATION OF STRING HANDLING");
    }

    public static void main(String[] args) {
        //a paragraph containing more than 10 sentences
        String paragraph = "Arjit Singh is a famous Indian singer, composer, musician, recordist, music producer, and music programmer. " +
                "Do we love him?" +
                "Yes, for sure!" +
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
                "Arjit Singh studied at Raja Bijay Singh High School and after that at Sripat Singh College." +
                "As stated by him he 'was a decent and hardworking student, but inclined towards music' and his parents trained him under a professional manner.";

        String[] dummyPara = paragraph.split("[.?!]+");
        for (String s : dummyPara) {
            System.out.println(s.trim());
        }

        //LinkedHashMap to store the sentences and no of words in each sentences
        Map<String, Integer> sentences;
        List<Map<String, Integer>> paraList = new LinkedList<>();
        int capacityOfParagraph = 10;

        int count = 0, words;
        while (count++ < capacityOfParagraph) {
            int finalIndex = getFinalIndex(paragraph); //get the index to get the sentence
            String indexVal = paragraph.substring(0, finalIndex + 1).trim();//get the nth sentence from the paragraph
            words = getWords(indexVal);//get the total words in the sentence
            sentences = new LinkedHashMap<>(); //creating new instances
            // put the key value pair in map
            sentences.put(indexVal, count);
            sentences.put("Words", words);
            paragraph = paragraph.substring(finalIndex + 1).trim(); //get new paragraph containing n-(1 to n) sentences
            paraList.add(sentences); // add the map to the list
        }
        sortList(paraList); //sort the list
        printList(paraList);//print the list
    }

    //method to sort the list according to key
    private static void sortList(List<Map<String, Integer>> mapList) {
        //using a comparator object sort the list comparing the key "Words"
        Comparator<Map<String, Integer>> mapComparator = Comparator.comparing(m -> m.get("Words"));
        mapList.sort(mapComparator);
    }

    //method to get the word count
    private static int getWords(String indexVal) {
        return new StringTokenizer(indexVal).countTokens();
    }

    //method to get the index of the para containing n-(1 to n) sentences
    private static int getFinalIndex(String para) {
        int indDot = para.indexOf(".");
        int indQuestionMark = para.indexOf("?");
        int indExclamationMark = para.indexOf("!");


        //if smallest value is -1 check if then and return the 2nd smallest value
        if (indDot == -1) {
            if (indExclamationMark == -1) {
                return indQuestionMark;
            } else return Math.min(indExclamationMark, indQuestionMark);
        } else if (indExclamationMark == -1) {
            if (indQuestionMark == -1) {
                return indDot;
            } else return Math.min(indDot, indQuestionMark);
        } else if (indQuestionMark == -1) {
            return Math.min(indDot, indExclamationMark);
        }
        // get the smallest value and return it if all indexes are >-1
        return (indDot < indQuestionMark) ? Math.min(indDot, indExclamationMark) : Math.min(indQuestionMark, indExclamationMark);

    }

    // method to print the map entries inside the list
    private static void printList(List<Map<String, Integer>> paraList) {
        System.out.println("\nSentences are: \n");
        for (int i = 0; i < paraList.size(); i++) {
            for (Map.Entry<String, Integer> stringIntegerEntry : paraList.get(i).entrySet()) {
                //Converting to Map.Entry so that we can get key and value separately
                System.out.println((i + 1) + ") " + stringIntegerEntry.getKey());
                break;
            }
        }
    }
}

