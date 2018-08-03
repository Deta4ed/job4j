package ru.job4j.list;

/**
 * SimpleArrayList.
 */
public class SimpleArrayList<T> {
    private int size;
    private Node<T> first;

    public void add(T date) {
        Node<T> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public T delete() {
        Node<T> result = this.first;
        this.first = this.first.next;
        this.size--;
        return result.reference;
    }

    public T get(int index) {
        Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.reference;
    }

    public int getSize() {
        return this.size;
    }

    private static class Node<T> {
        T reference;
        Node<T> next;

        Node(T reference) {
            this.reference = reference;
        }
    }
}
