package com.gs.dsa.Test;

import java.util.*;

public class SlidingWindow {

    private static int maxLenOfSubStringWithNoDuplicates(String s){

        int left = 0;
        int right = 0;
        int maxLen = Math.min(s.length(),1);
        Set<Character> set = new HashSet<>();
        while (right<s.length()){
            char c = s.charAt(right);
            while (set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            int windowSize = right-left+1;
            maxLen = Math.max(windowSize,maxLen);
            right++;
        }
        return maxLen;
    }
    private static int maxSumOfSubArrayWithSizeK(int[] arr, int k){

        int left = 0;
        int right = 0;
        int maxSum = 0;
        int windowSize = 0;

        while(right<arr.length){
            maxSum += arr[left];
            if(right-left+1 ==k){
                windowSize = Math.max(maxSum,windowSize);
                maxSum -= arr[left];
                left++;
            }
            right++;
        }
        return windowSize;
    }
    private static int noOfCountOcuurOfAnagram(String a, String b){

        int left = 0;
        int right = 0;
        int[] aCount = new int[26];
        int[] bCount = new int[26];

        int count = 0;

        for(char c : b.toCharArray()){
            bCount[c-'a']++;
        }

        while (right<a.length()){

            char c = a.charAt(right);
            aCount[c-'a']++;
            if(right-left+1 == b.length()){
                if(Arrays.equals(aCount,bCount)){
                    count++;
                }
                aCount[a.charAt(left)-'a']--;
                left++;
            }
            right++;
        }
        return count;

    }
    public static int longestSubStringWithKDistinct(String s, int k){
        if (s == null || s.isEmpty() || k == 0) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq.put(c, freq.getOrDefault(c, 0) + 1);

            // Shrink while violating frequency rules
            while (freq.get(c) > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    public static List firstNegNumInEveryWindowOfSizeK(int[] arr, int k){
        //arr = [12, -1, -7, 8, -15, 30, 16, 28], K = 3
        int left =0;
        //int right = arr.length-1;

        Deque<Integer> dq = new LinkedList<>();

        ArrayList<Integer> res = new ArrayList();

        for(int right=0; right<arr.length; right++){

            if(arr[right]<0){
                dq.offer(right);
            }
            if(right-left+1 == k){

                if(!dq.isEmpty()){
                    res.add(arr[dq.peek()]);
                }else {
                    res.add(0);
                }

                if(!dq.isEmpty() && dq.peek() == left){
                    dq.poll();
                }
                left++;
            }
        }
        return res;
    }
    public static int[] avgOfAllSubArrsSizeK(int[] arr, int k){
        //{1, 3, 2, 6, -1, 4, 1, 8, 2},5)
        /**int left =0;
        double[] res = new double[arr.length];
        int max = 0;

        for(int right =0; right<arr.length; right++){
            max += arr[right];
            if(right-left+1 == k){
                res.add((double)max/(double)k);
                max = max-arr[left];
                left++;
            }
        }
        return res.toArray(new int[0]); **/
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Sliding Window(Variable) Algorithm - Longest substring without duplicates");
        System.out.println(maxLenOfSubStringWithNoDuplicates("abcabcbb")); //abc 3
        System.out.println(maxLenOfSubStringWithNoDuplicates("bbbbb")); // b 1
        System.out.println(maxLenOfSubStringWithNoDuplicates("pwwkew")); // kew 3

        System.out.println("Sliding Window(Fixed) Algorithm - Anagram Check");
        System.out.println(noOfCountOcuurOfAnagram("cbaebabacd","abc")); //2
        System.out.println(noOfCountOcuurOfAnagram("abab","ab")); //3
        System.out.println(noOfCountOcuurOfAnagram("aaa","aa")); //2

        System.out.println(longestSubStringWithKDistinct("eceba",2)); //2 ece

        System.out.println(longestSubstring("aabbcc",2)); //6
        System.out.println(longestSubstring("abbaaac",2)); //5

        System.out.println(maxSumOfSubArrayWithSizeK(new int[]{2, 1, 5, 1, 3, 2},3));
        //9 {5,1,3}

        System.out.println(maxSumOfSubArrayWithSizeK(new int[]{2, 1, 5, 1, 3, 2},3));
        //9 {5,1,3}

        System.out.println(firstNegNumInEveryWindowOfSizeK(new int[]{12, -1, -7, 8, -15, 30, 16, 28},3));
        //[-1, -1, -7, -15, -15, 0]

        System.out.println(avgOfAllSubArrsSizeK(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2},5));
        //[2.2, 2.8, 2.4, 3.6, 2.8]


    }
}
