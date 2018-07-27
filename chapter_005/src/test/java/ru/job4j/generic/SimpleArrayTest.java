package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenAddThenFirstEnryIs46() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        simpleArray.add(46);
        assertThat(simpleArray.get(0), is(46));
    }

    @Test
    public void whenSetThenFirstEnryChanged() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("First");
        simpleArray.set(0, "Second");
        assertThat(simpleArray.get(0), is("Second"));
    }

    @Test
    public void whenDeleteThenFirstEntryIsSecond() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("First");
        simpleArray.add("Second");
        simpleArray.delete(0);
        assertThat(simpleArray.get(0), is("Second"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDeletedNonExistEntryIndexOutOfBoundsException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("First");
        simpleArray.delete(1);
    }

    @Test
    public void whenIterateSimpleArray() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("First");
        simpleArray.add("Second");
        simpleArray.add("Third");
        Iterator<String> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("First"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Second"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Third"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = RuntimeException.class)
    public void whenAddMoreSizeThenOverflow() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("First");
        simpleArray.add("Second");
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEndNextNoSuchElement() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("First");
        Iterator<String> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("First"));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.next(), is("Second"));
    }
}