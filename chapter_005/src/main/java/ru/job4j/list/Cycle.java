package ru.job4j.list;

public class Cycle<T> {

    /**
     * HasCycle - method checks for a closure in the linked list.
     * @param input - incoming list item.
     * @return - result.
     */
    boolean hasCycle(Node<T> input) {
        boolean result = false;
        if (input != null) {
            Node<T> slow = input;
            Node<T> fast = input;
            while (!result && fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                result = slow.equals(fast);
            }
        }
        return result;
    }

    class Node<T> {
        T value;
        Node<T> next;
    }
}
