package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    @Test
    public void whenPushThenFirstEntryIsTwo() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("Two");
        assertThat(simpleQueue.get(0), is("Two"));
    }

    @Test
    public void whenPollThenDeletedEntryIsOneAndFirstEntryIsTwo() {
        SimpleQueue<String> simpleQueue = new SimpleQueue<>();
        simpleQueue.push("One");
        simpleQueue.push("Two");
        simpleQueue.push("Three");
        String deleted = simpleQueue.poll();
        assertThat(deleted, is("One"));
        assertThat(simpleQueue.get(0), is("Two"));
    }
}