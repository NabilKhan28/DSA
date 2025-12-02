package com.gs.dsa;

import com.gs.dsa.Test.FloodFill;
import com.gs.dsa.Test.WordSearch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FloodFillTest {
    @Test
    void examples(){
        //        System.out.println(countOfConnNodes(5,new int[][]{{0,1},{1,2},{3,4}}));
        assertArrayEquals(new int[][] {{2,2,2},{2,2,0},{2,0,1}}, FloodFill.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2));
        assertArrayEquals(new int[][]{{9}}, FloodFill.floodFill(new int[][]{{5}}, 0, 0, 9));
        assertArrayEquals(new int[][]{{0,0,0},{0,1,1}}, FloodFill.floodFill(new int[][]{{0,0,0},{0,1,1}}, 1, 1, 1));

    }
}
