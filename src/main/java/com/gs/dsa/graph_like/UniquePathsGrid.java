
package com.gs.dsa.graph_like;

/**
 * Count unique paths in m x n grid (right/down moves).
 * Edge cases: m<=0 or n<=0, large m/n (integer overflow discussion optional).
 */
public final class UniquePathsGrid {
    private UniquePathsGrid() {}
    /** TODO: Implement DP or combinatorics. */
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int[][] dp = new int[m][n];

        // First row and column
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    /** Main method for testing */
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int result = uniquePaths(m, n);
        System.out.println("Unique paths for " + m + "x" + n + " grid: " + result);
    }
}
