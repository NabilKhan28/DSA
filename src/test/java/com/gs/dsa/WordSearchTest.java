package com.gs.dsa;

import com.gs.dsa.Test.CountOfConnectedNodes;
import com.gs.dsa.Test.WordSearch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordSearchTest {
    @Test
    void examples(){
        //        System.out.println(countOfConnNodes(5,new int[][]{{0,1},{1,2},{3,4}}));

        assertThat(WordSearch.wordSearch(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED")).isEqualTo(true);
        assertThat(WordSearch.wordSearch(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCDEFG")).isEqualTo(false);
        assertThat(WordSearch.wordSearch(new char[][]{{'B'}},"A")).isEqualTo(false);
    }
}
