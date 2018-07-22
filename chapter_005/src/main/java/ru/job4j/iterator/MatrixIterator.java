package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * MatrixIterator.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class MatrixIterator implements Iterator {
    private final int[][] values;
    private int result;
    private int i = 0;
    private int j = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return i != values.length;
    }

    @Override
    public Object next() {
        if (i == values.length) {
            throw new NoSuchElementException();
        }
        result = values[i][j];
        if (j == values[i].length - 1) {
            i++;
            j = 0;
        } else {
            j++;
        }
        return result;
    }
}
