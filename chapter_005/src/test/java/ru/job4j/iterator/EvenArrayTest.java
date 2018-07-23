package ru.job4j.iterator;

import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EvenArrayTest {
    private Iterator it;

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        it = new EvenArray(new int[]{1, 2, 3, 4, 5, 6, 7}).iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeUnsupportedOperation() {
        it = new EvenArray(new int[]{1}).iterator();
        it.remove();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        it = new EvenArray(new int[]{1, 2, 3, 4, 5, 6, 7}).iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    @Test
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenArray(new int[]{1}).iterator();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven() {
        it = new EvenArray(new int[]{2, 4, 6, 8}).iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }

    @Test
    public void foreacheAllNumbersAreEven() {
        EvenArray evenArray = new EvenArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        int index = 0;
        for (Object cell : evenArray) {
            index += 2;
            assertThat(index, is(cell));
        }
    }
}