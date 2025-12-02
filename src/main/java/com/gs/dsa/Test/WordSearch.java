package com.gs.dsa.Test;

public class WordSearch {
    public static boolean wordSearch(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, word, i, j, 0)) return true;
        return false;
    }

    private static boolean dfs(char[][] board, String w, int i, int j, int k) {
        if (k == w.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != w.charAt(k)) return false;

        char temp = board[i][j];
        board[i][j] = '#';

        boolean found = dfs(board, w, i + 1, j, k + 1)
                || dfs(board, w, i - 1, j, k + 1)
                || dfs(board, w, i, j + 1, k + 1)
                || dfs(board, w, i, j - 1, k + 1);

        board[i][j] = temp;
        return found;
    }
}
