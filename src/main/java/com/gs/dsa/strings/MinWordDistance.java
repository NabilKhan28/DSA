
package com.gs.dsa.strings;

/**
 * Minimum number of words in-between two target words (nearest occurrence).
 * Edge cases: targets missing, multiple occurrences, adjacency, same word twice.
 */
public final class MinWordDistance {
    private MinWordDistance() {}
    /** TODO: Track last indices of each word and compute in-between distance. */
    public static int minDistance(String[] words, String w1, String w2) {

        int lastPos1 = -1;
        int lastPos2 = -1;
        int minValues = Integer.MAX_VALUE;
        boolean sameWord = w1.equals(w2);

        for(int i=0; i<words.length; i++){

            String word = words[i];
            if(sameWord && word.equals(w1)){
                if(lastPos1 != -1){
                    minValues = Math.min(minValues, i-lastPos1-1);
                }
                lastPos1 =i;
            }else {

                if(word.equals(w1)){
                    lastPos1 =i;
                    if(lastPos2 != -1){
                        minValues = Math.min(minValues, Math.abs(lastPos2-lastPos1)-1);
                    }
                }
                if(word.equals(w2)){
                    lastPos2 =i;
                    if(lastPos1 != -1){
                        minValues = Math.min(minValues, Math.abs(lastPos2-lastPos1)-1);
                    }
                }
            }
        }



        return minValues==Integer.MAX_VALUE?-1:minValues;
    }

    public static void main(String[] args) {
        System.out.println(minDistance(
                new String[]{"the", "quick", "brown", "fox", "quick"},
                "quick", "fox")); // 0

        System.out.println(minDistance(
                new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "coding", "practice")); // 2

        System.out.println(minDistance(
                new String[]{"a", "b", "c", "d", "a"},
                "a", "a")); // 3

        System.out.println(minDistance(
                new String[]{"hello", "world"},
                "foo", "bar")); // -1
    }
}
