package ru.job4j.parser;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ParserBraceTest {

    @Test (expected = ArrayStoreException.class)
    public void whenCreateParserBraseWithAnOddArrayThenArrayStoreException() {
        char[][] target = new char[][]{
                {'{', '}'},
                {'[', ']'},
                {'('}
        };
        ParserBrace parserBrace = new ParserBrace(new Pair(target));
    }

    @Test
    public void whenParserBraceInStringThen() {
        int[][] expect = new int[][] {
                {24, 25},
                {5, 22},
                {1, 3},
                {7, 21}
        };
        int[][] result = new ParserBrace(new Pair()).parcer("{{ }m{a[b[{c{]fg}}d)e]} {}");
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    @Test
    public void whenParserAnyCharThen() {
        char[][] target = new char[][]{
                {' ', ' '}
        };
        int[][] expect = new int[][] {
                {2, 23}
        };
        int[][] result = new ParserBrace(new Pair(target)).parcer("{{ }m{a[b[{c{]fg}}d)e]} {}");
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
