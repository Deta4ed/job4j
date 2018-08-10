package ru.job4j.set;

import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedSetTest {

    @Test
    public void whenAddTwoIdenticalThenSizeOne() {
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        linkedSet.add(2);
        linkedSet.add(2);
        assertThat(linkedSet.size(), is(1));
    }

    @Test
    public void whenAddThenFirstEntryIsTwo() {
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        linkedSet.add(2);
        assertThat(linkedSet.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNonExistEntryThenIndexOutOfBoundsException() {
        LinkedSet<String> linkedSet = new LinkedSet<>();
        linkedSet.add("Zero");
        linkedSet.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEndNextNoSuchElement() {
        LinkedSet<String> linkedSet = new LinkedSet<>();
        linkedSet.add("First");
        Iterator<String> iterator = linkedSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("First"));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.next(), is("Second"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhenIterableThenConcurrentModificationException() {
        LinkedSet<Integer> linkedSet = new LinkedSet<>();
        linkedSet.add(1);
        for (Integer element : linkedSet) {
            linkedSet.add(4);
        }
    }
}