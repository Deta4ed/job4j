package ru.job4j.nonblock;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicReference;

public class NonBlockingCashTest {

    @Test
    public void whenAddModelToCash() {
        NonBlockingCash cash = new NonBlockingCash();
        Base model = new Base(1, "Test");
        cash.add(model);
        String expected = cash.get(1).getName();
        assertThat(expected, is("Test"));
    }

    @Test
    public void whenDeleteModelFromCache() {
        NonBlockingCash cash = new NonBlockingCash();
        Base model = new Base(1, "Test");
        cash.add(model);
        cash.delete(model);
        assertNull(cash.get(1));
    }

    @Test
    public void whenThrowException() throws InterruptedException, OptimisticException {
/*        AtomicReference<Exception> exception = new AtomicReference<>();
        NonBlockingCash cash = new NonBlockingCash();
        Base model = new Base(1, "Test");
        cash.add(model);
        Runnable runnable = () -> {
            try {
                for (int index = 0; index < 100; index++) {
                    Base modelRun = cash.get(1);
                    int versionRun = modelRun.getVersion();
                    modelRun.setName("Test" + versionRun);
                    cash.update(versionRun, modelRun);
                }
            } catch (Exception e) {
                exception.set(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        assertThat(exception.get().getMessage(), is("Invalid version"));*/
    }
}