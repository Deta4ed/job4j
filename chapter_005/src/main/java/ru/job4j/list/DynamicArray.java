package ru.job4j.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * DynamicArray.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class DynamicArray<T> implements Iterable<T> {
    private int size = 10;
    private int position;
    private int modCount;
    private Object[] container = new Object[size];

    public void add(T object) {
        if (position == size) {
            size *= 2;
            this.container = Arrays.copyOf(this.container, size);
        }
        this.container[position++] = object;
        this.modCount++;
    }

    public T get(int index) {
        if (index >= position || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) this.container[index];
    }

    public int size() {
        return position;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[count++];
            }
        };
    }
}
