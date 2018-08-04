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
        Node<T> first = this.header.next;
        this.header.next = first.next;
        this.size--;
        return first.item;
    }

    public void push(T value) {
        super.add(value);
    }
}
