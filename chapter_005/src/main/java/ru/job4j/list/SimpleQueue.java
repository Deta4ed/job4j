package ru.job4j.list;

/**
 * SimpleQueue.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class SimpleQueue<T> extends DynamicLinked<T> {

    public SimpleQueue() {
        super();
    }

    public T poll() {
        return super.deleteFirst();
    }

    public void push(T value) {
        super.add(value);
    }
}
