package ru.job4j.blocking;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SimpleBlockingQueueTest {
    @Test
    public void when() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(5);
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());
        Runnable runnableConsumer = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Integer current = queue.poll();
                        if (current != null) {
                            result.add(current);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread firstConsumer = new Thread(runnableConsumer);
        Thread secondConsumer = new Thread(runnableConsumer);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int index = 1; index != 10; index++) {
                    queue.offer(index);
                }
                queue.closeSession();
            }
        });
        firstConsumer.start();
        secondConsumer.start();
        producer.start();
        firstConsumer.join();
        secondConsumer.join();
        producer.join();
        assertTrue(queue.isEmpty());
        assertThat(result.toArray(), arrayContainingInAnyOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).toArray()));
    }
}