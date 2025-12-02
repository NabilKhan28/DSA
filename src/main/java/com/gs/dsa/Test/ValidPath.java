package com.gs.dsa.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPath {
    public static void main(String[] args) {
        System.out.println(validPath(5,new int[][]{{0,1},{0,2},{1,3},{3,4}}, 0, 4));

    }

    public static boolean validPath(int n, int[][] grid, int src, int dest) {

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

}
