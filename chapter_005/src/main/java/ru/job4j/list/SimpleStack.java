package ru.job4j.list;

/**
 * SimpleStack.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class SimpleStack<T> extends DynamicLinked<T> {

    public SimpleStack() {
        super();
    }

    public T poll() {
        Node<T> last = this.header.prev;
        this.header.prev = last.prev;
        this.header.prev.next = header;
        this.size--;
        return last.item;
    }

    public void push(T value) {
        super.add(value);
    }
}


