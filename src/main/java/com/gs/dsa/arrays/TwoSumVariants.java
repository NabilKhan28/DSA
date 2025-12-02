
package com.gs.dsa.arrays;

import java.util.*;

/**
 * Variants: first valid pair (hashmap), smallest indices (lexicographic), largest indices.
 * Expected: O(n) for first; others can pre-index positions.
 */
public final class TwoSumVariants {
    private TwoSumVariants() {}
    /** TODO: First valid pair using hashmap. */
    public static int[] twoSumFirst(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-2,-2};
    }
    /** TODO: Lexicographically smallest index pair. */
    public static int[] twoSumSmallestIndices(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        for (int i=0; i<nums.length; i++){
            for (int j= i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    if(result[0] == -1 || i<result[0] || (i==result[0] && j<result[1])){
                        result[0] =i;
                        result[1] =j;
                    }
                }
            }
        }
        return result;
    }
    /** TODO: Lexicographically largest index pair. */
    public static int[] twoSumLargestIndices(int[] nums, int target) {

        int[] result = new int[]{-1, -1};
        for(int i=nums.length-1; i>=0; i--){
            for(int j =i-1; j>=0; j--){
                if(nums[i] + nums[j] == target){
                    if(result[0]==-1 || j>result[0] || (j==result[0] && i>result[1])){
                        result[0] = j;
                        result[1] = i;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 7, 2};
        int target = 9;

        System.out.println("First valid pair: " + Arrays.toString(twoSumFirst(nums, target)));
        System.out.println("Smallest indices: " + Arrays.toString(twoSumSmallestIndices(nums, target)));
        System.out.println("Largest indices: " + Arrays.toString(twoSumLargestIndices(nums, target)));
    }
}
