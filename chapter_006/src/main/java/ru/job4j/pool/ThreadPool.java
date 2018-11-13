package ru.job4j.pool;

import java.util.ArrayList;
import java.util.List;
import ru.job4j.blocking.SimpleBlockingQueue;

public class ThreadPool {
    private final List<Thread> threads = new ArrayList<>();
    private final SimpleBlockingQueue<Work> tasks = new SimpleBlockingQueue<>(10);
    private List<Integer> completedTasks = new ArrayList<>();

    public  ThreadPool() {
        int maxSize = Runtime.getRuntime().availableProcessors();
        for (int index = 0; index != maxSize; index++) {
            Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Work current = tasks.poll();
                        if (current != null) {
                            current.run();
                            completedTasks.add(current.getIndex());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    public void work(Work work) {
        tasks.offer(work);
    }

    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    public List<Thread> getThreads() {
        return threads;
    }

    public SimpleBlockingQueue<Work> getTasks() {
        return tasks;
    }

    public List<Integer> getCompletedTasks() {
        return completedTasks;
    }
}
