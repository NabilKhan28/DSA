package com.gs.dsa.Test;

import java.util.ArrayList;
import java.util.List;

public class HasCycle {
    public static void main(String[] args) {
        System.out.println(hasCycle(3,new int[][]{{0,1},{1,2},{2,0}}));
    }
    public static boolean hasCycle(int n, int[][] edges) {
        //3, {0,1},{1,2},{2,0}
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) graph.get(e[0]).add(e[1]);

        int[] state = new int[n];

        for (int i = 0; i < n; i++)
            if (state[i] == 0 && dfs(i, graph, state)) return true;

        return false;
    }

    private static boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        state[node] = 1; // visiting
        for (int nei : graph.get(node)) {
            if (state[nei] == 1) return true;
            if (state[nei] == 0 && dfs(nei, graph, state)) return true;
        }
        state[node] = 2; // visited
        return false;
    }
}
