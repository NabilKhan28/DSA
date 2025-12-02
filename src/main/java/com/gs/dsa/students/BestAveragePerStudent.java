
package com.gs.dsa.students;

import java.util.*;

/**
 * Compute best average per student from [name, mark] pairs.
 * Edge cases: invalid/negative marks, missing rows, zero-count division.
 */
public final class BestAveragePerStudent {
    private BestAveragePerStudent() {}
    /** TODO: Aggregate sum/count per name and compute averages. */
    public static String bestAverages(String[][] nameMarks) {
        Map<String,long[]> map1 = new HashMap<>();

        for(String[] s : nameMarks){
            map1.computeIfAbsent(s[0],k->new long[2]);
            map1.get(s[0])[0]++;
            map1.get(s[0])[1] += Long.parseLong(s[1]);
        }
        Map<String,Double> map2 = new HashMap<>();
        double maxAverage = 0;
        String averageName = "";
        for(Map.Entry<String,long[]> b : map1.entrySet()){
            map2.put(b.getKey(), (double) (b.getValue()[1]/b.getValue()[0]));
            String name = b.getKey();
            double average = (double) (b.getValue()[1]/b.getValue()[0]);
           // maxAverage = Math.max(maxAverage,average);
            //System.out.println("average "+average);
            if(maxAverage<average){
                averageName = name;
            }

        }
        return averageName;
    }

    public static void main(String[] args) {
        String[][] input = {
                {"Alice", "-90"},
                {"Bob", "80"},
                {"Alice", "100"},
                {"Bob", "70"},
                {"Charlie", String.valueOf(Integer.MAX_VALUE)},
                {"Charlie", String.valueOf(Integer.MIN_VALUE)}

        };
        System.out.println(bestAverages(input));
    }
}
