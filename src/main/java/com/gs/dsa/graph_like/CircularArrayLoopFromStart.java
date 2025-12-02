
package com.gs.dsa.graph_like;

/**
 * From a start index, detect cycle length with consistent movement direction.
 * Edge cases: self-loops invalid, mixed directions, out-of-bounds.
 */
public final class CircularArrayLoopFromStart {
    private CircularArrayLoopFromStart() {}
    /** TODO: Implement Floyd cycle detection with direction checks. */

    public static int loopLength(int[] nums, int startIndex) {
        int n = nums.length;
        if (n == 0 || startIndex < 0 || startIndex >= n) return -1;

        // initial direction (+1 or -1)
        int dir = nums[startIndex] > 0 ? 1 : -1;

        int slow = startIndex;
        int fast = startIndex;

        while (true) {

            slow = nextIndex(nums, slow, dir);
            if (slow == -1) return -1;

            fast = nextIndex(nums, fast, dir);
            if (fast == -1) return -1;

            fast = nextIndex(nums, fast, dir);
            if (fast == -1) return -1;

            if (slow == fast) break; // cycle detected
        }

        // Check for self-loop: invalid
        if (slow == nextIndex(nums, slow, dir)) return -1;

        // Now measure the cycle length
        int count = 1;
        int cur = nextIndex(nums, slow, dir);
        while (cur != slow) {
            count++;
            cur = nextIndex(nums, cur, dir);
        }

        return count; // valid cycle length
    }

    // Safe next-move respecting direction and no self-loops
    private static int nextIndex(int[] nums, int idx, int dir) {
        int n = nums.length;
        int move = nums[idx];

        // invalid: direction flip
        if ((move > 0 ? 1 : -1) != dir) return -1;

        int next = (idx + move) % n;
        if (next < 0) next += n;

        // self-loop invalid
        if (next == idx) return -1;

        return next;
    }

    // Optional test main
    public static void main(String[] args) {
        int[] nums1 = {2, -1, 1, 2, 2};
        System.out.println(loopLength(nums1, 0)); // 3

        int[] nums2 = {-1, 2};
        System.out.println(loopLength(nums2, 1)); // -1 (dir mismatch)

        int[] nums3 = {1, 1, 1};
        System.out.println(loopLength(nums3, 0)); // 3

        int[] nums4 = {1, -1, 1};
        System.out.println(loopLength(nums4, 0)); // -1 (mixed direction)
    }}
