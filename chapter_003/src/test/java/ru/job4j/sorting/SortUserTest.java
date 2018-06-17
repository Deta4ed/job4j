package ru.job4j.sorting;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class SortUserTest {

    @Test
    public void whenSortUsersByAgeThenFirsUserIvan() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Petr", 34),
                new User("Ivan", 28),
                new User("Vitaly", 32),
                new User("Mike", 28)));
        Set<User> result = SortUser.sort(users);
        Iterator<User> it = result.iterator();
        assertThat("Ivan", is(it.next().getName()));
    }
}
