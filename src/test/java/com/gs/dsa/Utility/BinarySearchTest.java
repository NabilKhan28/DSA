package com.gs.dsa.Utility;

import com.gs.dsa.Test.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {
    @Test
    void basic(){
        assertThat(BinarySearch.getTheIndexOfTarget(new int[]{},2)).isEqualTo(-1);
        assertThat(BinarySearch.getTheIndexOfTarget(new int[]{1},1)).isEqualTo(0);
        assertThat(BinarySearch.getTheIndexOfTarget(new int[]{1},0)).isEqualTo(-1);
        assertThat(BinarySearch.getTheIndexOfTarget(new int[]{2,3,4,5},4)).isEqualTo(2);
    }
}
