package ru.job4j.concurrent;

import net.jcip.annotations.ThreadSafe;
import net.jcip.annotations.GuardedBy;
import ru.job4j.list.DynamicArray;
import java.util.Iterator;

/**
 * ConcurrentDynamicArray.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
@ThreadSafe
public class ConcurrentDynamicArray<T> {
    @GuardedBy("this")
    private final DynamicArray<T> dynamicArray = new DynamicArray<>();

    public synchronized void add(T object) {
        dynamicArray.add(object);
    }

    public synchronized T get(int index) {
        return (T) dynamicArray.get(index);
    }

    public synchronized boolean contains(T value) {
        return dynamicArray.contains(value);
    }

    public synchronized int size() {
        return dynamicArray.size();
    }

    public synchronized Iterator<T> iterator() {
        DynamicArray<T> cloned = new DynamicArray<>();
        for (T current : dynamicArray) {
            cloned.add(current);
        }
        return cloned.iterator();
    }
}
