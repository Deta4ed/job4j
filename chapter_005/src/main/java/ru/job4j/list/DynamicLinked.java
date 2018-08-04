package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicLinked.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class DynamicLinked<T> implements  Iterable<T> {
    protected int size;
    private int modCount;
    protected Node<T> header;

    public DynamicLinked() {
        header = new Node<>(null, null, null);
        header.next = header;
        header.prev = header;
    }

    public void add(T value) {
        Node<T> newLink = new Node<>(value, header, header.prev);
        header.prev.next = newLink;
        header.prev = newLink;
        if (header.next == header) {
            header.next = newLink;
        }
        this.size++;
        this.modCount++;
    }

    private void validIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        validIndex(index);
        Node<T> result = this.header.next;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.item;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = header;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return current.next != header;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                current = current.next;
                return (T) current.item;
            }
        };
    }

    protected static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T element, Node<T> next, Node<T> prev) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
