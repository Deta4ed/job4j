package ru.job4j.blocking;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();
    private final int maxSize;
    volatile private boolean state = true;

    public SimpleBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void offer(T value) {
        while (queue.size() == maxSize) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        queue.offer(value);
        this.notifyAll();
    }

    public synchronized T poll() throws InterruptedException {
        while (isEmpty()) {
            if (!state) {
                Thread.currentThread().interrupt();
                break;
            } else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        T result = queue.poll();
        this.notifyAll();
        return result;
    }

    public synchronized void closeSession() {
        state = false;
        this.notifyAll();
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
