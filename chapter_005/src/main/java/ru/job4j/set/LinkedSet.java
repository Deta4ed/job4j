package ru.job4j.set;

import ru.job4j.list.DynamicLinked;
import java.util.Iterator;

/**
 * LinkedSet.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class LinkedSet<T> implements Iterable<T> {
    private DynamicLinked<T> container = new DynamicLinked<>();

    public void add(T value) {
        boolean exist = false;
        for (T element : container) {
            if (value.equals(element)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            container.add(value);
        }
    }

    public int size() {
        return container.getSize();
    }

    public T get(int index) {
        return container.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}
