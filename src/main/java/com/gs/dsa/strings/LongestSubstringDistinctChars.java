
package com.gs.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Length of longest substring with all distinct characters (sliding window).
 * Edge cases: empty, repeated clusters, large alphabets.
 */
public final class LongestSubstringDistinctChars {
    private LongestSubstringDistinctChars() {}
    /** TODO: Implement O(n) sliding window with last-seen positions. */
    public static int lengthOfLongestDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();

        int start =0;
        int max =0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(map.get(c)+1, start);
            }
            map.put(c,i);
            max = Math.max(max, i-start+1);

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestDistinct("abcabcbb"));
    }
}
