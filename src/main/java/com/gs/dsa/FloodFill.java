package com.gs.dsa;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor)
            dsa(image, sr, sc, oldColor, newColor);
        return image;
    }

    private static void dsa(int[][] img, int r, int c, int oldColor, int newColor) {
        if (r < 0 || c < 0 || r >= img.length || c >= img[0].length || img[r][c] != oldColor)
            return;

        img[r][c] = newColor;

        dsa(img, r + 1, c, oldColor, newColor);
        dsa(img, r - 1, c, oldColor, newColor);
        dsa(img, r, c + 1, oldColor, newColor);
        dsa(img, r, c - 1, oldColor, newColor);
    }

}
