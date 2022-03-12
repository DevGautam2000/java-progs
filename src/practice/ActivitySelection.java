package practice;
/*
     AUTHOR: GAUTAM CHANDRA SAHA
     DATE & TIME: 16/04/21 AT 2:53 PM
     DESCRIPTION:

*/

import java.util.*;

public class ActivitySelection {
    public static void main(String[] args) {

        LinkedList<Map<String, Integer>> mainList = new LinkedList<>();//list to store the map

        Map<String, Integer> map = null;
        int size = randRange(10).intValue();
        System.out.println("Total Activities: " + size + "\n");

        for (int i = 0; i < size; i++) {

            int start = randRange(20).intValue();
            int finish = randRange(30).intValue();

            while (start >= finish) {
                finish = randRange(30).intValue();
            }
            map = new LinkedHashMap<>();

            map.put("Activity No", (i + 1));
            map.put("Start Time", start);
            map.put("Finish Time", finish);
            mainList.add(map);
        }

        System.out.println("\nInput List:");
        printList(mainList);
        activitySelection(mainList);

    }

    private static void printList(LinkedList<Map<String, Integer>> mainList) {
        for (Map<String, Integer> entry :
                mainList) {
            System.out.println(entry);

        }
    }

    private static void activitySelection(LinkedList<Map<String, Integer>> mainList) {
        sortList(mainList);

        int i = 0;
        if (mainList.size() > 0) {

            System.out.println("\nSorted List:");
            printList(mainList);

            System.out.println("\nActivities selected:\n");
            System.out.println("Activity " + mainList.getFirst().get("Activity No"));

            for (int j = 1; j < mainList.size(); j++) {
                if (mainList.get(j).get("Start Time") >= mainList.get(i).get("Finish Time")) {
                    System.out.println("Activity " + mainList.get(j).get("Activity No"));
                    i = j;
                }

            }

        } else {
            System.out.println("\nList is empty");
        }


    }

    private static void sortList(LinkedList<Map<String, Integer>> mainList) {
        mainList.sort(Comparator.comparing(m -> m.get("Finish Time")));
    }

    private static Double randRange(int range) {
        return Math.floor(Math.random() * range) + 1;
    }

}
