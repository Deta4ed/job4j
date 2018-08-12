package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void whenAddTwoUsersToMapThenOneElement() {
        User user = new User("Vic", 1, new GregorianCalendar(1900, 11, 30));
        User user1 = new User("Vic", 1, new GregorianCalendar(1900, 11, 30));
        Map<User, Object> map = new HashMap<>();
        map.put(user, 10);
        map.put(user1, 10);
        System.out.println(map);
    }

}