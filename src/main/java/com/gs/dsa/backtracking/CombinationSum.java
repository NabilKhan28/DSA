
package com.gs.dsa.backtracking;

import java.util.*;

/**
 * Return all unique combinations summing to target; candidates may be reused.
 * Edge cases: empty candidates, target < smallest, duplicates handling via sort.
 */
public final class CombinationSum {
    private CombinationSum() {}
    /** TODO: Implement DFS/backtracking with pruning. */
    //public static List<List<Integer>> combinationSum(int[] candidates, int target) { return new ArrayList<>(); }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates); // helps pruning
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int remain, int start,
                                  List<Integer> path, List<List<Integer>> result) {

        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];

            // Pruning: no need to continue if current value exceeds remaining target
            if (val > remain) break;

            path.add(val);
            backtrack(candidates, remain - val, i, path, result); // reuse allowed
            path.remove(path.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = combinationSum(candidates, target);

        System.out.println("Combinations:");
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}
