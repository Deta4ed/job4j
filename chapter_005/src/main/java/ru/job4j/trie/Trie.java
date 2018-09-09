package ru.job4j.trie;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Trie {
    private final TrieNode root = new TrieNode();

    public void put(String word, int position) {
        TrieNode currentNode = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                currentNode.children.put(ch, new TrieNode());
            }
            currentNode = currentNode.children.get(ch);
        }
        if (currentNode.positions == null) {
            currentNode.positions  = new TreeSet<>();
        }
        currentNode.positions.add(position);
    }

    public boolean find(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                return false;
            } else {
                currentNode = currentNode.children.get(ch);
            }
        }
        return true;
    }

    public Set<Integer> getPosition(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                return null;
            } else {
                currentNode = currentNode.children.get(ch);
            }
        }
        return currentNode.positions;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Set<Integer> positions;
    }
}
