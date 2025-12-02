package com.gs.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfConnectedNodes {
    public static void main(String[] args) {
        System.out.println(countOfConnNodes(5,new int[][]{{0,1},{1,2},{3,4}}));
    }

    public static int countOfConnNodes(int n, int[][] grid) {

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
}
