package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CounterTest {
    @Test
    public void countTest() {
        Counter count = new Counter();
        int result = count.add(1, 10);
        assertThat(result, is(30));
    }

    @Test
    public void countTest1() {
        Counter count = new Counter();
        int result = count.add1(1, 10);
        assertThat(result, is(30));
    }
}
