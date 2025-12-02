package com.gs.dsa.Utility;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SlidingWindowTest {
    @Test void basic(){
        assertThat(SlidingWindow.longestSubStringWithKDistinct("eceba",2)).isEqualTo(3);
        assertThat(SlidingWindow.longestSubStringWithKDistinct("aa",1)).isEqualTo(2);
        assertThat(SlidingWindow.longestSubStringWithKDistinct("a",0)).isEqualTo(0);
        assertThat(SlidingWindow.longestSubStringWithKDistinct("",2)).isEqualTo(0);
    }

    @Test void longestSubStringKtimes(){
        assertThat(SlidingWindow.longestSubstring("aabbcc",2)).isEqualTo(6);
        assertThat(SlidingWindow.longestSubstring("abbaaac",2)).isEqualTo(5);
        assertThat(SlidingWindow.longestSubstring("aaabbc",1)).isEqualTo(3);
        assertThat(SlidingWindow.longestSubstring("",2)).isEqualTo(0);
    }
}
