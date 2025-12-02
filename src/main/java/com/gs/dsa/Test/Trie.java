package com.gs.dsa.Test;

import java.util.Arrays;
import java.util.List;

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            //System.out.println("aaaa "+idx);
            //System.out.println("aaaa "+curr.children[idx]);
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isEndOfWord;
    }

    // Search prefix (startsWith)
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }
    public String shortest(String word) {
        TrieNode curr = root;

        StringBuilder res = new StringBuilder();
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return word;
            res.append(c);
            curr = curr.children[idx];
            if(curr.isEndOfWord) return res.toString();
        }
        return word;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
//        trie.insert("car");
//        trie.insert("dog");

//        System.out.println(trie.search("cat"));     // true
//        System.out.println(trie.search("cap"));     // false
//        System.out.println(trie.startsWith("ca"));  // true

        List<String> dictionary = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary,sentence));

        List<String> dictionary1 = Arrays.asList("a","b","c");
        String sentence1 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(replaceWords(dictionary1,sentence1));

        System.out.println('p'-'a');
    }
    public static String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder res = new StringBuilder();
        Trie trie = new Trie();

        for(String s : dictionary){
            trie.insert(s);
        }
        for(String s : sentence.split(" ")){
            res.append(trie.shortest(s)).append(" ");
        }
        return res.toString();
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
    }
}
