package ru.job4j.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final List<Thread> threads = new ArrayList<>();
    private final Queue<Work> tasks = new LinkedBlockingQueue<>();
    private List<Integer> completedTasks = new ArrayList<>();

    public  ThreadPool() {
        int maxSize = Runtime.getRuntime().availableProcessors();
        for (int index = 0; index != maxSize; index++) {
            Thread thread = new Thread(() -> {
                synchronized (this) {
                    while (!Thread.currentThread().isInterrupted()) {
                        while (!tasks.isEmpty()) {
                            Work current = tasks.poll();
                            completedTasks.add(current.getIndex());
                            current.run();
                        }
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    public synchronized void work(Work work) {
        tasks.offer(work);
        this.notifyAll();
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public Queue<Work> getTasks() {
        return tasks;
    }

    public List<Integer> getCompletedTasks() {
        return completedTasks;
    }
}
