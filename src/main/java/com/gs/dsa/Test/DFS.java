package com.gs.dsa.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {

    public static void main(String[] args) {
        System.out.println(validPath(5,new int[][]{{0,1},{0,2},{1,3},{3,4}}, 0, 4));
        System.out.println(countOfConnNodes(5,new int[][]{{0,1},{1,2},{3,4}}));
        System.out.println(hasCycle(3,new int[][]{{0,1},{1,2},{2,0}}));
    }
    //1. Path Exists in a Graph
    private static boolean validPath(int n, int[][] grid, int src, int dest) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] e : grid){
            map.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[n];
        return dfs(map,src,dest,visited);
    }

    private static boolean dfs(Map<Integer, List<Integer>> map, int src, int dest, boolean[] visited) {
        if(src==dest) return true;
        visited[src] = true;
        for(int n : map.get(src)){
            if(!visited[n]){
                if(dfs(map,n,dest,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    //2. Connected Components in an Undirected Graph
    private static int countOfConnNodes(int n, int[][] grid) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] e : grid){
            map.get(e[0]).add(e[1]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(map,i,visited);
            }
        }
        return count;
    }

    private static void dfs(Map<Integer, List<Integer>> map, int src, boolean[] visited) {

        visited[src] = true;
        for(int n : map.get(src)){
            if(!visited[n]){
                dfs(map,n,visited);
            }
        }
    }
    //3. Detect Cycle in a Graph
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
