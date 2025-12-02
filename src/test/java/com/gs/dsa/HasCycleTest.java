package com.gs.dsa;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HasCycleTest {
    @Test
    void examples(){
        //System.out.println(validPath(5,new int[][]{{0,1},{0,2},{1,3},{3,4}}, 0, 4));

        assertTrue(HasCycle.hasCycle(3, new int[][]{{0,1},{1,2},{2,0}}));
        assertFalse(HasCycle.hasCycle(5, new int[][]{{0,1},{2,3}}));
    }
}
