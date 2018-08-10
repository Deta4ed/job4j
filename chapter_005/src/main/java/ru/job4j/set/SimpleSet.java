package ru.job4j.set;

import ru.job4j.list.DynamicArray;
import java.util.Iterator;

/**
 * SimpleSet.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class SimpleSet<T> implements Iterable<T> {
    private final DynamicArray<T> list;

    public SimpleSet() {
        list = new DynamicArray<>();
    }

    public T get(int index) {
        return list.get(index);
    }

    public void add(T model) {
        if (!list.contains(model)) {
            list.add(model);
        }
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
