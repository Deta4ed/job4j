package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixIteratorTest {
    private Iterator<Integer> itMatrixArray;
    private Iterator<Integer> itJaggedArray;

    @Before
    public void setUp() {
        itMatrixArray = new MatrixIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        itJaggedArray = new MatrixIterator(new int[][]{{1}, {3, 4}, {7}});
    }

    @Test
    public void testMatrixArrayThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(itMatrixArray.next(), is(1));
        assertThat(itMatrixArray.next(), is(2));
        assertThat(itMatrixArray.next(), is(3));
        assertThat(itMatrixArray.next(), is(4));
        assertThat(itMatrixArray.next(), is(5));
        assertThat(itMatrixArray.next(), is(6));
    }

    @Test
    public void testJaggedArrayThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(itJaggedArray.next(), is(1));
        assertThat(itJaggedArray.next(), is(3));
        assertThat(itJaggedArray.next(), is(4));
        assertThat(itJaggedArray.next(), is(7));
    }

    @Test
    public void testMatrixArraySequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.next(), is(1));
        assertThat(itMatrixArray.next(), is(2));
        assertThat(itMatrixArray.next(), is(3));
        assertThat(itMatrixArray.next(), is(4));
        assertThat(itMatrixArray.next(), is(5));
        assertThat(itMatrixArray.next(), is(6));
    }

    @Test
    public void testJaggedArraySequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(itJaggedArray.hasNext(), is(true));
        assertThat(itJaggedArray.hasNext(), is(true));
        assertThat(itJaggedArray.next(), is(1));
        assertThat(itJaggedArray.next(), is(3));
        assertThat(itJaggedArray.next(), is(4));
        assertThat(itJaggedArray.next(), is(7));
    }

    @Test
    public void testMatrixArrayHasNextNextSequentialInvocation() {
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.next(), is(1));
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.next(), is(2));
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.next(), is(3));
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.next(), is(4));
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.next(), is(5));
        assertThat(itMatrixArray.hasNext(), is(true));
        assertThat(itMatrixArray.next(), is(6));
        assertThat(itMatrixArray.hasNext(), is(false));
    }

    @Test
    public void testJaggedArrayHasNextNextSequentialInvocation() {
        assertThat(itJaggedArray.hasNext(), is(true));
        assertThat(itJaggedArray.next(), is(1));
        assertThat(itJaggedArray.hasNext(), is(true));
        assertThat(itJaggedArray.next(), is(3));
        assertThat(itJaggedArray.hasNext(), is(true));
        assertThat(itJaggedArray.next(), is(4));
        assertThat(itJaggedArray.hasNext(), is(true));
        assertThat(itJaggedArray.next(), is(7));
        assertThat(itJaggedArray.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void shoulThrowNoSuchElementException() {
        itMatrixArray = new MatrixIterator(new int[][]{});
        itMatrixArray.next();
    }
}