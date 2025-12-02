
package com.gs.dsa.games;

/**
 * Josephus-style elimination: return elected student number (1..n).
 * Expected: O(n) iterative formula or linked simulation; discuss space trade-offs.
 */
public final class JosephusLikeElimination {
    private JosephusLikeElimination() {}
    /** TODO: Implement iterative formula (0-index then +1). */

    public static int elect(int n, int k) {
        // f(i) = (f(i-1) + k) % i, with f(1) = 0 in 0-index
        int result = 0;

        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
        }

        return result + 1; // convert to 1-indexed
    }

    // Test main method
    public static void main(String[] args) {
        System.out.println(elect(5, 2));  // Output: 3
        System.out.println(elect(7, 3));  // Output: 4
        System.out.println(elect(1, 5));  // Output: 1
    }
}
