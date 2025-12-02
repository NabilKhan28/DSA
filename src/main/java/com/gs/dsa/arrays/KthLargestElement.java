
package com.gs.dsa.arrays;

import java.util.PriorityQueue;

/**
 * Return the k-th largest element.
 * Preferred approaches: min-heap of size k (n log k) or quickselect (avg O(n)).
 */
public final class KthLargestElement {
    private KthLargestElement() {
    }

    /**
     * TODO: Implement using heap or quickselect.
     */
    public static int kthLargest(int[] nums, int k) {

        if(nums == null || nums.length < k ){
            throw new IllegalArgumentException("Array is too small");
        }
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int num:nums){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll(); // placeholder
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(kthLargest(nums, k)); // Output: 5
    }
}
