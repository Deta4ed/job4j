package ru.job4j.trie;

import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class WordIndexTest {
    String text = "просто текст, для (проверки) программы - для построения индекса! Текст предназначен просто для проверки";
    WordIndex wordIndex = new WordIndex();

    @Before
    public void initWordIndex() {
        wordIndex.loadText(text);
    }

    @Test
    public void whenSeachPartOfWordResultIsNull() {
        Set<Integer> result = wordIndex.getIndexes4Word("тек");
        assertNull(result);
    }

    @Test
    public void whenSeachNotExistingWordResultIsNull() {
        Set<Integer> result = wordIndex.getIndexes4Word("Слово");
        assertNull(result);
    }

    @Test
    public void whenSeachWordThenCorrectResult() {
        Set<Integer> result = wordIndex.getIndexes4Word("текст");
        String lowerText = text.toLowerCase();
        int lastIndex = 0;
        for (Integer cell : result) {
            lastIndex = lowerText.indexOf("текст", lastIndex);
            assertThat(cell, is(lastIndex));
            lastIndex++;
        }
    }
}