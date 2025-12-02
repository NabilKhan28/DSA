package com.gs.dsa;

import com.gs.dsa.Test.ValidPath;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ValidPathTest {
    @Test
    void examples(){
        //System.out.println(validPath(5,new int[][]{{0,1},{0,2},{1,3},{3,4}}, 0, 4));

        assertThat(ValidPath.validPath(5,new int[][]{{0,1},{0,2},{1,3},{3,4}}, 0, 4)).isEqualTo(true);
        assertThat(ValidPath.validPath(5,new int[][]{{0,1},{0,2},{1,2},{3,4}}, 0, 4)).isEqualTo(false);
    }
}
