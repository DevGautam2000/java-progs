package rishabh.progs;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 15/04/21 AT 3:03 PM
     DESCRIPTION:

*/

import java.util.*;

public class StringHand {


    public static void main(String[] args) {

        String para = "My name is Gautam." +
                "I am 20 years old." +
                "I like coding!" +
                "I am currently pursuing Engineering." +
                "I like to sing." +
                "I like girls." +
                "So what?" +
                "Are u single?" +
                "Are u single?" +
                "Are u single?" +
                "Are u single?" +
                "Are u single?" +
                "Lets go ride!" +
                "I like pawris!" +
                "Gautam is done!" +
                "No moree pain!";

//__________________________________________________________________
        Map<Float, String> sentence = new LinkedHashMap<>();


        float count = 0, words, pairCount = 0;
        int j = 0;

        for (int k = 0; k < para.length() && count < 10; k++) {
            String check = String.valueOf(para.charAt(k));

            if ((check.equals("!") || check.equals("?") || check.equals("."))) {
                words = 0;
                String indexVal = para.substring(j, para.indexOf(check));


                for (int i = 0; i < indexVal.length(); i++) {

                    if (indexVal.charAt(i) == ' ') {
                        words++;
                    }

                }

                if (!sentence.containsKey((words + 1))) {
                    sentence.put((words + 1), indexVal);
                } else {
                    float pairing = (words + 1) + (++pairCount / 10f); //(5)+(0.1)=5.1
                    sentence.put((pairing), indexVal);
                }
                j = para.indexOf(check) + 1;
                para = para.substring(j);

                count++;
                k = j = 0;
            }
        }


        for (Map.Entry<Float, String> entries :
                sentence.entrySet()) {
            System.out.println(entries.getKey() + ": " + entries.getValue());
        }
        LinkedList<Map.Entry<Float, String>> sentencesList = new LinkedList<>(sentence.entrySet());

        sentencesList.sort(Map.Entry.comparingByKey());

        sentence.clear();

        // get entry from list to the map
        for (Map.Entry<Float, String> entry : sentencesList) {
            sentence.put(entry.getKey(), entry.getValue());
        }
        System.out.println("__________________");
        for (Map.Entry<Float, String> entries :
                sentence.entrySet()) {
            System.out.println(entries.getKey() + ": " + entries.getValue());
        }
        System.out.println("Sentences are: ");
        int c = 1;
        for (Map.Entry<Float, String> entries :
                sentence.entrySet()) {
            System.out.println((c++) + ") " + entries.getValue());
        }
    }
}
