
package com.gs.dsa.games;

/**
 * Given array with next-index pointers, return cycle length.
 * Edge cases: invalid 0-pointer, multiple cycles, single-node cycle.
 */
public final class CircularArrayGameLength {
    private CircularArrayGameLength() {}
    /** TODO: Implement Floyd cycle detection tailored to index mapping. */

    public static int cycleLength(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;

        // Validate all pointers first
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] >= n) return -1;
        }

        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];                // 1-step
            fast = nums[fast];                // 2-step part 1
            fast = nums[fast];                // 2-step part 2

            if (slow == fast) break;          // Cycle detected
        }

        // Measure cycle length
        int count = 1;
        fast = nums[slow];
        while (fast != slow) {
            fast = nums[fast];
            count++;
        }

        return count;
    }

    // Test main (optional)
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};    // cycle 0→1→2→0 length = 3
        int[] nums2 = {1, 2, 3, 4, 4}; // cycle at index 4 length = 1
        int[] nums3 = {2, 0, 1};    // full cycle length = 3
        int[] nums4 = {1, -1, 2};   // invalid → -1

        System.out.println(cycleLength(nums1)); // 3
        System.out.println(cycleLength(nums2)); // 1
        System.out.println(cycleLength(nums3)); // 3
        System.out.println(cycleLength(nums4)); // -1
    }
}
