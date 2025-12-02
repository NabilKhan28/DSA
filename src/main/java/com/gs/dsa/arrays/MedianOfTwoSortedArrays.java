
package com.gs.dsa.arrays;

import java.util.Map;

/**
 * Find the median of two sorted arrays without fully merging them.
 * Expected: ~O(log (m+n)) using partition-based binary search.
 * Edge cases: empty one array, skewed sizes, duplicates, negatives.
 */
public final class MedianOfTwoSortedArrays {
    private MedianOfTwoSortedArrays() {}
    /** TODO: Implement optimal partition-based median. */
    public static double findMedianSortedArrays(int[] a, int[] b) {

        if(a == null || b ==null){
            throw new IllegalArgumentException("Input array cannot be null");
        }

        if(a.length > b.length){
            return findMedianSortedArrays(b,a);
        }

        int m = a.length;
        int n = b.length;

        int total = m+n;
        int half = (total+1)/2;

        int left = 0;
        int right = m;

        while (left<=right){
            int i = (left+right)/2;
            int j = half-i;

            int aLeft = (i==0)?Integer.MIN_VALUE:a[i-1];
            int aRight = (i==m)?Integer.MAX_VALUE:a[i];

            int bLeft = (j==0)?Integer.MIN_VALUE:b[j-1];
            int bRight = (j==n)?Integer.MAX_VALUE:b[j];

            if(aLeft <= bRight && bLeft <= aRight){

                if(total%2==0){
                    int leftMax = Math.max(aLeft,bLeft);
                    int rightMin = Math.min(aRight,bRight);
                    return (leftMax+rightMin)/2.0;
                }else {
                    return Math.max(aLeft,bLeft);
                }
            } else if (aLeft > bRight) {
                right = i-1;
            }else {
                left = i+1;
            }


        }
        throw new IllegalArgumentException("No valid partition");
        //return Double.NaN; // placeholder to force test failure
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3};
        int[] b1 = {2};
        System.out.println(findMedianSortedArrays(a1, b1)); // 2.0

        int[] a2 = {1, 2};
        int[] b2 = {3, 4};
        System.out.println(findMedianSortedArrays(a2, b2)); // 2.5

        int[] a3 = {};
        int[] b3 = {1};
        System.out.println(findMedianSortedArrays(a3, b3)); // 1.0

        int[] a4 = {0, 0};
        int[] b4 = {0, 0};
        System.out.println(findMedianSortedArrays(a4, b4)); // 0.0

    }
}
