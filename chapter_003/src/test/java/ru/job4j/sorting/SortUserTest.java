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

    @Test
    public void whenSortUsersByNameLeghtThenFirsUserIvan() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Vitaly", 32),
                new User("Ivan", 28),
                new User("Michael", 28)));
        List<User> result = SortUser.sortNameLength(users);
        Iterator<User> it = result.iterator();
        assertThat("Ivan", is(it.next().getName()));
    }

    @Test
    public void whenSortUsersByAllFiledsThenFirsUserIvan() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("Vitaly", 32),
                new User("Ivan", 28),
                new User("Ivan", 27),
                new User("Michael", 28)));
        List<User> result = SortUser.sortByAllFields(users);
        Iterator<User> it = result.iterator();
        User user = it.next();
        assertThat("Ivan", is(user.getName()));
        assertThat(27, is(user.getAge()));
    }

}
