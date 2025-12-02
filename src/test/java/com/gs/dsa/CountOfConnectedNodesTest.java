package com.gs.dsa;

import com.gs.dsa.Test.CountOfConnectedNodes;
import com.gs.dsa.Test.ValidPath;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountOfConnectedNodesTest {
    @Test
    void examples(){
        //        System.out.println(countOfConnNodes(5,new int[][]{{0,1},{1,2},{3,4}}));

        assertThat(CountOfConnectedNodes.countOfConnNodes(5,new int[][]{{0,1},{1,2},{3,4}})).isEqualTo(2);
        assertThat(CountOfConnectedNodes.countOfConnNodes(5,new int[][]{{0,1},{1,2},{2,4}})).isEqualTo(2);
    }
}
