package ru.job4j.list;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void when() {
        List<User> users = List.of(
                new User(1, "Ivan", "Moscow"),
                new User(2, "Petr", "Bryansk"));
        HashMap<Integer, User> expect = new HashMap<>(Map.of(
                1, new User(1, "Ivan", "Moscow"),
                2, new User(2, "Petr", "Bryansk")));
        HashMap<Integer, User> result = UserConvert.process(users);
        assertThat(result, is(expect));
    }
}
