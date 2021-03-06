package ru.job4j.pool;

import org.junit.Test;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class ThreadPoolTest {
    @Test
    public void whenRunAllThenGetIt() throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        Thread pThread = new Thread(() -> {
            for (int outer = 0; outer != 3; outer++) {
                for (int inner = 1; inner != 5; inner++) {
                    threadPool.work(new Work(inner + outer * 4));
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (threadPool.getTasks().isEmpty()) {
                threadPool.shutdown();
                break;
            }
            for (Thread thread : threadPool.getThreads()) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pThread.start();
        pThread.join();
        assertThat(threadPool.getCompletedTasks(), containsInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }
}
