package ru.job4j.concurrent;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Iterator;

public class ConcurrentDynamicArrayTest {

    @Test
    public void whenTwoThreadsWorkWithSameCollection() throws InterruptedException {
        ConcurrentDynamicArray<Integer> concurrentDynamicArray = new ConcurrentDynamicArray<>();
        concurrentDynamicArray.add(100);
        concurrentDynamicArray.add(200);
        Iterator<Integer> iterator = concurrentDynamicArray.iterator();

        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int index = 5; index < 100; index++) {
                    concurrentDynamicArray.add(index);
                }
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                assertThat(iterator.hasNext(), is(true));
                assertThat(iterator.next(), is(100));
                assertThat(iterator.hasNext(), is(true));
                assertThat(iterator.next(), is(200));
                assertThat(iterator.hasNext(), is(false));
            }
        });

        one.start();
        two.start();
        one.join();
        one.join();
        assertThat(concurrentDynamicArray.size(), is(97));
    }
}