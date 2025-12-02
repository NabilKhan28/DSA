package com.gs.dsa.Test;

import java.util.ArrayList;
import java.util.List;

public class DSA {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
        System.out.println(findAnagrams("abab","ab"));
    }



    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<=s.length()-p.length(); i++){
            //System.out.println(s.substring(i,i+p.length()));
            //System.out.println("iii "+i);
            //System.out.println("s.length() "+s.length());


                if(isAnagram(s.substring(i,i+p.length()),p)){
                    res.add(i);}

        }
        return res;
    }

    public static boolean isAnagram(String subString, String target){
        StringBuilder subStringFinal = new StringBuilder();
        StringBuilder targetFinal = new StringBuilder();

        System.out.println(subString+ "  "+subString);
        if(stringToOrder(subString).equals(stringToOrder(target))){
            return true;
        }
        return false;
    }

    public static String stringToOrder(String a){
        //char[] aa = a.toString().toCharArray();
        List<Character> aaa = new ArrayList<>();
        for(char c : a.toCharArray()){
            aaa.add(c);
        }
        return aaa.stream().sorted().toList().toString();


    }


}
