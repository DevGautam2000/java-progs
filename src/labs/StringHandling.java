package labs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 15/04/21 AT 3:03 PM
     DESCRIPTION:

*/


import java.util.*;

public class StringHandling {
    static {
        System.out.println("IMPLEMENTATION OF STRING HANDLING\n");
    }


    public static void main(String[] args) {

        //a paragraph containing more than 10 sentences
        String para = "Arjit Singh is a famous Indian singer, composer, musician, recordist, music producer, and music programmer. " +
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


//      LinkedHashMap to store the sentences and no of words in each sentences
        Map<Float, String> sentences = new LinkedHashMap<>();
        int capacityOfParagraph = 10;

        float count = 0, words, pairCount = 0;
        int j = 0;

        //loop to check if the para contains <= 10 sentences
        for (int k = 0; k < para.length() && count < capacityOfParagraph; k++) {
            String check = String.valueOf(para.charAt(k)); //storing each letter in a paragraph one at a time

            //check if the character obtained is one of these
            if ((check.equals("!") || check.equals("?") || check.equals("."))) {
                words = 0;
                //get the nth sentence from the paragraph
                String indexVal = para.substring(j, para.indexOf(check) + 1).trim();
                //get the total words in the sentence
                words = getWords(indexVal);
                //pairCount to store sentences with same word count in the Map
                pairCount = getPairCount(sentences, words, pairCount, indexVal);
                //the start index of the next sentence
                j = para.indexOf(check) + 1;
                //get the next sentence from paragraph
                para = para.substring(j);
                count++; //increment count
                k = j = 0;
            }
        }

//        for (Map.Entry<Float, String> entries :
//                sentences.entrySet()) {
//            System.out.println(entries.getKey() + ": " + entries.getValue());
//        }

//        sort the Map according to keys to get sentences in increasing order of words
        sortMapByKey(sentences);


//        print the entries in the Map
        System.out.println("Sentences are: ");
        int c = 1;
        for (Map.Entry<Float, String> entries :
                sentences.entrySet()) {
            System.out.println((c++) + ") " + entries.getValue() + " --> " + entries.getKey().intValue() + " words");
        }
    }

    //    function to get the pairCount to put sentences with same word count with distinct key
    private static float getPairCount(Map<Float, String> sentences, float words, float pairCount, String indexVal) {
        if (!sentences.containsKey((words))) {// check if the key already exits
            sentences.put((words), indexVal);
        } else {// if not generate a key near about for the same word count
            float pairing = (words) + (++pairCount / 10f); // for e.g., (5[wordCount])+(0.1)=5.1[new key]
            sentences.put((pairing), indexVal);
        }
        return pairCount;
    }

    //    function to sort the map comparing by key
    private static void sortMapByKey(Map<Float, String> sentences) {
        LinkedList<Map.Entry<Float, String>> sentenceList = new LinkedList<>(sentences.entrySet());
        sentenceList.sort(Map.Entry.comparingByKey());
        sentences.clear();

        // get entry from list to the map
        for (Map.Entry<Float, String> entry : sentenceList) {
            sentences.put(entry.getKey(), entry.getValue());
        }
    }

    //    function to get the word count
    private static float getWords(String indexVal) {
        return new StringTokenizer(indexVal).countTokens();
    }

}
