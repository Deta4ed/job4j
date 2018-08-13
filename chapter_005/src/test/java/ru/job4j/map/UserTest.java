package ru.job4j.map;

import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
    @Test
    public void whenHashIsCountedByFiledsThenEqualsObjectsHash() {
        User user = new User("Vic", 1, new GregorianCalendar(1990, 11, 30));

        char[] name = user.getName().toCharArray();
        GregorianCalendar calendar = (GregorianCalendar) user.getBirthday();
        int hashChildren = 1;

        int hashName = 0;
        for (int index = 0; index != name.length; index++) {
            hashName = hashName * 31 + name[index];
        }

        int otheritems = 1
                | (calendar.getFirstDayOfWeek() << 1)
                | (calendar.getMinimalDaysInFirstWeek() << 4)
                | (calendar.getTimeZone().hashCode() << 7);

        long t = calendar.getTimeInMillis();
        int gregorianCutoverDate = 577736;
        int hashCalendar = (int) t ^ (int) (t >> 32) ^ otheritems;
        hashCalendar = hashCalendar ^ gregorianCutoverDate;

        int result = 1;
        result = result * 31 + hashName;
        result = result * 31 + hashChildren;
        result = result * 31 + hashCalendar;

        assertThat(result, is(user.hashCode()));
        assertThat(result, is(Objects.hash(user.getName(), user.getChildren(), user.getBirthday())));
    }
}