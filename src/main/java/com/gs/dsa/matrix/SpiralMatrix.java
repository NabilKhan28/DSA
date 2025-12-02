
package com.gs.dsa.matrix;

import java.util.*;

/**
 * Return spiral order traversal of an m x n matrix.
 * Edge cases: 1xN, Nx1, empty, non-rectangular assumptions.
 */
public final class SpiralMatrix {
    private SpiralMatrix() {}
    /** TODO: Implement layer-by-layer traversal. */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length-1;

        int left = 0;
        int right = matrix[0].length-1;

        while (top<=bottom && left<=right){

            for(int i =left; i<=right; i++){
                result.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                result.add(matrix[i][right]);
            }
            right--;

            if(top<=bottom){
                for(int j=right; j>=left; j--){
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if(left<=right){
                for(int j=bottom; j>=top; j--){
                    result.add(matrix[j][left]);
                }
                left++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(spiralOrder(matrix)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
