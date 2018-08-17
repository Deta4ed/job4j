package ru.job4j.tree;

import java.util.*;

/**
 * Tree.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Tree<T extends Comparable<T>> implements SimpleTree<T> {
    private Node<T> root;
    private int modCount = 0;
    private int size = 0;

    public Tree(T value) {
        this.root = new Node<T>(value);
    }

    @Override
    public boolean add(T parent, T child) {
        boolean result = false;
        Optional<Node<T>> optParent = findBy(parent);
        if (!findBy(child).isPresent() && optParent.isPresent()) {
            optParent.get().add(new Node<>(child));
            result = true;
            size++; modCount++;
        }
        return result;
    }

    @Override
    public Optional<Node<T>> findBy(T value) {
        Optional<Node<T>> rsl = Optional.empty();
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private Queue<Node<T>> data = new LinkedList<>();
            { data.offer(Tree.this.root); }

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return !data.isEmpty();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> item = data.poll();
                for (Node<T> child: item.leaves()) {
                    data.offer(child);
                }
                return item.getValue();
            }
        };
    }
}
