package ru.job4j.trie;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordIndex {
    private final Trie storage = new Trie();

    public void loadText(String text) {
        Pattern pattern = Pattern.compile("[а-яА-Я_a-zA-Z]+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            storage.put(matcher.group(), matcher.start());
        }
    }

    public Set<Integer> getIndexes4Word(String searchWord) {
        return storage.getPosition(searchWord);
    }
}
