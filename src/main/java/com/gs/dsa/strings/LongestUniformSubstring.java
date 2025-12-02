
package com.gs.dsa.strings;

import java.util.Arrays;

/**
 * Longest run of same character; return [start, length].
 * Edge cases: empty string, all same char, ties (choose earliest start).
 */
public final class LongestUniformSubstring {
    private LongestUniformSubstring() {}
    /** TODO: Implement linear scan of runs. */
    public static int[] longestUniform(String s) {

        if(s.isEmpty() || s ==null){
            return new int[]{-1,0};
        }

        int currLen =1;
        int currStart =0;

        int bestLen = 1;
        int bestStart =0;

        for(int i=1; i<s.length(); i++){

            if(s.charAt(i) == s.charAt(i-1)){
                currLen++;
            }else{
                if(currLen>bestLen){
                    bestLen = currLen;
                    bestStart = currStart;
                }
                currStart = i;
                currLen = 1;
            }
        }

        if(currLen>bestLen){
            bestLen = currLen;
            bestStart = currStart;
        }
        return new int[]{bestStart,bestLen};
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(longestUniform("aaabbbaaac"))); // [0, 3]
        System.out.println(java.util.Arrays.toString(longestUniform("aabbbbcc")));   // [2, 4]
        System.out.println(java.util.Arrays.toString(longestUniform("abc")));        // [0, 1]
        System.out.println(java.util.Arrays.toString(longestUniform("")));           // [-1, 0]
        System.out.println(java.util.Arrays.toString(longestUniform("xxxxx")));
    }
}
