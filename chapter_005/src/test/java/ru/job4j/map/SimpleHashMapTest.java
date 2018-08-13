package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenAddElementByKeyThenTrue() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        assertThat(hashMap.insert(3, "Jason"), is(true));
        assertThat(hashMap.insert(4, "Piter"), is(true));
        assertThat(hashMap.insert(1, "Mike"), is(true));
        assertThat(hashMap.insert(2, "Vasya"), is(true));
    }

    @Test
    public void whenAddElementWithExistingKeyThenFalse() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        assertTrue(hashMap.insert(1, "Jason"));
        assertTrue(hashMap.insert(2, "Piter"));
        assertTrue(hashMap.insert(3, "Mike"));
        assertTrue(hashMap.insert(4, "Vasya"));
        assertTrue(hashMap.insert(5, "Ann"));
        assertFalse(hashMap.insert(1, "Tor"));
    }

    @Test
    public void whenGetElementByKeyThenReturnValue() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        hashMap.insert(99, "Jason");
        hashMap.insert(44, "Piter");
        hashMap.insert(21, "Vasya");
        hashMap.insert(85, "Tor");
        String res = hashMap.get(44);
        String exp = "Piter";
        assertThat(res, is(exp));
    }

    @Test
    public void whenDeleteElementFromMapThenTrue() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        hashMap.insert(1, "Jason");
        hashMap.insert(2, "Piter");
        hashMap.insert(3, "Vasya");
        hashMap.insert(4, "Mike");
        hashMap.insert(5, "Ann");
        assertTrue(hashMap.delete(4));
        assert (hashMap.get(4) == null);
    }

    @Test
    public void whenHasNextElementNextReturnIt() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        hashMap.insert(1, "Jason");
        hashMap.insert(2, "Piter");
        hashMap.insert(3, "Vasya");
        Iterator<String> iterator = hashMap.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Jason"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Piter"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Vasya"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddWhenIterableThenConcurrentModificationException() {
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();
        hashMap.insert(1, "Jason");
        hashMap.insert(2, "Piter");
        hashMap.insert(3, "Vasya");
        for (String element : hashMap) {
            hashMap.insert(5, "Ann");
        }
    }
}