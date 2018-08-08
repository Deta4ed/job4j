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
        return super.deleteLast();
    }

    public void push(T value) {
        super.add(value);
    }
}


