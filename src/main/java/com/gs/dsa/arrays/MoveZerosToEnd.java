
package com.gs.dsa.arrays;

/**
 * Move zeros to the end in-place while preserving order of non-zeros.
 * Expected: O(n) time, O(1) space.
 */
public final class MoveZerosToEnd {
    private MoveZerosToEnd() {}
    /** TODO: Implement stable compaction. */
    public static void moveZeros(int[] nums) {
        // no-op placeholder
        int pos =0;

        for(int num:nums){
            if(num!=0){
                nums[pos++] = num;
            }
        }
        while (pos<nums.length){
            nums[pos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeros(nums);
        System.out.println(java.util.Arrays.toString(nums));
    }
}
