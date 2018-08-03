package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {

    @Test
    public void whenAddThenFirstEntryIsTwo() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(2);
        assertThat(dynamicArray.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetNonExistEntryThenIndexOutOfBoundsException() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("Zero");
        dynamicArray.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEndNextNoSuchElement() {
        DynamicArray<String> dynamicArray = new DynamicArray<>();
        dynamicArray.add("First");
        Iterator<String> iterator = dynamicArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("First"));
        assertThat(iterator.hasNext(), is(false));
        assertThat(iterator.next(), is("Second"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhenIterableThenConcurrentModificationException() {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.add(1);
        for (Integer element : dynamicArray) {
            dynamicArray.add(4);
        }
    }
}