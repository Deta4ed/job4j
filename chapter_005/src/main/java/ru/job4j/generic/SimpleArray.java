package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleArray.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {
    private final Object[] objects;
    private int position = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        if (this.position >= this.objects.length) {
            throw new RuntimeException("Overflow");
        }
        this.objects[position++] = model;
    }

    private void validIndex(int index) {
        if (index >= position || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        validIndex(index);
        return (T) this.objects[index];
    }

    public void set(int index, T model) {
        validIndex(index);
        this.objects[index] = model;
    }

    public void delete(int index) {
        validIndex(index);
        System.arraycopy(this.objects, index + 1, this.objects, index, position - index - 1);
        position--;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < position;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[count++];
            }
        };
    }
}