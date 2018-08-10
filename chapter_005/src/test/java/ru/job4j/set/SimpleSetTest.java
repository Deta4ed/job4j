package ru.job4j.set;

import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddTwoIdenticalThenSizeOne() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(2);
        simpleSet.add(2);
        assertThat(simpleSet.size(), is(1));
    }

    @Test
    public void whenAddThenFirstEntryIsTwo() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(2);
        assertThat(simpleSet.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNonExistEntryThenIndexOutOfBoundsException() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("Zero");
        simpleSet.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEndNextNoSuchElement() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("First");
        Iterator<String> iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("First"));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.next(), is("Second"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhenIterableThenConcurrentModificationException() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        for (Integer element : simpleSet) {
            simpleSet.add(4);
        }
    }
}