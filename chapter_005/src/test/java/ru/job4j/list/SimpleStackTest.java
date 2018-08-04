package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void whenPushThenFirstEntryIsTwo() {
        SimpleStack<String> simpleStack = new SimpleStack<>();
        simpleStack.push("Two");
        assertThat(simpleStack.get(0), is("Two"));
    }

    @Test
    public void whenPollThenDeletedEntryIsThreeAndLastEntryIsTwo() {
        SimpleStack<String> simpleStack = new SimpleStack<>();
        simpleStack.push("One");
        simpleStack.push("Two");
        simpleStack.push("Three");
        String deleted = simpleStack.poll();
        assertThat(deleted, is("Three"));
        assertThat(simpleStack.get(simpleStack.getSize() - 1), is("Two"));
    }
}