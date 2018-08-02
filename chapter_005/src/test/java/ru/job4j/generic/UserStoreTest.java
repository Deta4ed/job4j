package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {
    private SimpleArray<User> list;
    private UserStore us;

    @Before
    public void init() {
        list = new SimpleArray<>(5);
        us = new UserStore(list);
        us.add(new User("One"));
        us.add(new User("Two"));
        us.add(new User("Three"));
    }

    @Test
    public void whenUserStoreAddThenAdded() {
        User fourth = new User("fourth");
        us.add(fourth);
        assertThat(list.get(3), is(fourth));
    }

    @Test
    public void whenUserStoreReplaceThenReplaced() {
        User fifth = new User("Fifth");
        us.replace("One", fifth);
        assertThat(list.get(0), is(fifth));
    }

    @Test
    public void whenUserStoreDelete() {
        assertThat(us.delete("Two"), is(true));
        assertThat(us.delete("Tw0"), is(false));
    }

    @Test
    public void whenUserStoreFindById() {
        list = new SimpleArray<>(5);
        us = new UserStore(list);
        us.add(new User("One"));
        us.add(new User("Two"));
        us.add(new User("Three"));
        assertThat(us.findById("Three"), is(list.get(2)));
    }
}