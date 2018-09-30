package ru.job4j.storage;

import org.junit.Test;
import org.hamcrest.Matchers;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;

public class UserStorageTest {
    @Test
    public void whenUserStorageUsesMultipleThreadsThenExpectedResult() throws InterruptedException {
        UserStorage userStorage = new UserStorage();
        Thread init = new Thread(new Runnable() {
            @Override
            public void run() {
                userStorage.add(new User(4, 0));
                userStorage.add(new User(1, 100));
                userStorage.add(new User(2, 200));
                userStorage.add(new User(3, 0));
            }
        });
        Thread del = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                while (!result) {
                    result = userStorage.delete(new User(4, 600));
                }
            }
        });
        Thread up = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                while (!result) {
                    result = userStorage.update(new User(3, 300));
                }
            }
        });
        Thread transferOne = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                while (!result) {
                    result = userStorage.transfer(3, 1, 200);
                }
            }
        });
        Thread transferTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result = false;
                while (!result) {
                    result = userStorage.transfer(1, 2, 300);
                }
            }
        });
        transferOne.start();
        transferTwo.start();
        up.start();
        init.start();
        del.start();

        init.join();
        del.join();
        up.join();
        transferOne.join();
        transferTwo.join();

        List<User> expected = new ArrayList<>();
        expected.add(new User(1, 0));
        expected.add(new User(2, 500));
        expected.add(new User(3, 100));
        assertThat(expected, Matchers.containsInAnyOrder(userStorage.getStorage().toArray()));
    }
}