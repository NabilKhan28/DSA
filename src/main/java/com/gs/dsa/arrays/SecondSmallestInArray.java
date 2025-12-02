
package com.gs.dsa.arrays;

/**
 * Find second smallest distinct value in one pass.
 * Edge cases: duplicates, all equal, fewer than 2 distinct values.
 */
public final class SecondSmallestInArray {
    private SecondSmallestInArray() {}
    /** TODO: Implement single-pass tracking of min and second min. */
    public static int secondSmallest(int[] nums) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num:nums){
            if(num<min){
                secondMin = min;
                min = num;
            }else if(num > min && num < secondMin){
                secondMin = num;
            }
        }

        return (secondMin == Integer.MAX_VALUE)?Integer.MIN_VALUE:secondMin;
    }

    public static void main(String[] args) {
        System.out.println(secondSmallest(new int[]{5, 2, 9, 1, 3}));
    }
}
