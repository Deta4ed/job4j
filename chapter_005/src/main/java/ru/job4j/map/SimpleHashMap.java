package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleHashMap.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class SimpleHashMap<K, V> implements Iterable<V> {
    private Entry[] container;
    private int modCount = 0;
    private int count = 0;
    private int size = 10;

    public SimpleHashMap() {
        this.container = new Entry[size];
    }

    private int getIndexFromHash(int hash) {
        return (hash & 0x7FFFFFFF) % container.length;
    }

    private Entry[] resize() {
        size *= 2;
        Entry[] result = new Entry[size];
        for (Entry cell : container) {
            if (cell == null) {
                continue;
            }
            result[getIndexFromHash(cell.hash)] = cell;
        }
        return result;
    }

    public boolean insert(K key, V value) {
        int hash = key.hashCode();
        int index = getIndexFromHash(hash);
        if (!(container[index] == null)) {
            return false;
        }
        Entry<K, V> cell = new Entry<>(hash, key, value);
        container[index] = cell;
        modCount++;
        count++;
        if (count == container.length / 2) {
            container = resize();
        }
        return true;
    }

    public V get(K key) {
        int index = getIndexFromHash(key.hashCode());
        if (container[index] == null) {
            return null;
        }
        return (V) container[index].value;
    }

    public boolean delete(K key) {
        int index = getIndexFromHash(key.hashCode());
        if (index >= 0 && index < size) {
            container[index] = null;
            modCount++;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private final int expectedModCount = modCount;
            private int position = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int index = position; index < size; index++) {
                    if (container[index] != null) {
                        position = index;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (V) container[position++].value;
            }
        };
    }

    private static class Entry<K, V> {
        final int hash;
        final K key;
        V value;

        private Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
