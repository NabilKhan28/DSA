
package com.gs.dsa.strings;

import java.util.LinkedHashMap;

/**
 * Index of first non-repeating character. Edge cases: empty, all repeating, Unicode.
 */
public final class FirstNonRepeatingChar {
    private FirstNonRepeatingChar() {}
    /** TODO: Implement frequency counting then single pass. */
    public static int indexOfFirstUnique(String s) {

        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0; i<s.length(); i++){

            if(map.get(s.charAt(i)) == 1){

                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOfFirstUnique("leetcoldetleetcoldet"));
    }
}
