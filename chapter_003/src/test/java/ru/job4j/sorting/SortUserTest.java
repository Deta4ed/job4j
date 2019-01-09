package ru.job4j.sorting;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class SortUserTest {

    @Test
    public void whenSortUsersByAgeThenFirsUserIvan() {
        Set<User> result = SortUser.sort(List.of(
                new User("Petr", 34),
                new User("Ivan", 28),
                new User("Vitaly", 32),
                new User("Mike", 28)));
        Iterator<User> it = result.iterator();
        assertThat("Ivan", is(it.next().getName()));
    }

    @Test
    public void whenSortUsersByNameLeghtThenFirsUserIvan() {
        List<User> result = SortUser.sortNameLength(new ArrayList<>(List.of(
                new User("Vitaly", 32),
                new User("Ivan", 28),
                new User("Michael", 28))));
        Iterator<User> it = result.iterator();
        assertThat("Ivan", is(it.next().getName()));
    }

    @Test
    public void whenSortUsersByAllFiledsThenFirsUserIvan() {
        List<User> result = SortUser.sortByAllFields(new ArrayList<>(List.of(
                new User("Vitaly", 32),
                new User("Ivan", 28),
                new User("Ivan", 27),
                new User("Michael", 28))));
        Iterator<User> it = result.iterator();
        User user = it.next();
        assertThat("Ivan", is(user.getName()));
        assertThat(27, is(user.getAge()));
    }
}
