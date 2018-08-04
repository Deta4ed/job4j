package ru.job4j.list;

import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicLinkedTest {
    @Test
    public void whenAddThenFirstEntryIsTwo() {
        DynamicLinked<Integer> dynamicLinked = new DynamicLinked<>();
        dynamicLinked.add(2);
        assertThat(dynamicLinked.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNonExistEntryThenIndexOutOfBoundsException() {
        DynamicLinked<String> dynamicLinked = new DynamicLinked<>();
        dynamicLinked.add("Zero");
        dynamicLinked.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEndNextNoSuchElement() {
        DynamicLinked<String> dynamicLinked = new DynamicLinked<>();
        dynamicLinked.add("First");
        Iterator<String> iterator = dynamicLinked.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("First"));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.next(), is("Second"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhenIterableThenConcurrentModificationException() {
        DynamicLinked<Integer> dynamicLinked = new DynamicLinked<>();
        dynamicLinked.add(1);
        for (Integer element : dynamicLinked) {
            dynamicLinked.add(4);
        }
    }
}