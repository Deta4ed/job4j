package ru.job4j.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public static Set<User> sort(List<User> userList) {
        Set<User> users = new TreeSet<>();
        users.addAll(userList);
        return users;
    }

    public static List<User> sortNameLength(List<User> userList) {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (o1.getName().length() < o2.getName().length()) ? -1 : ((o1.getName().length() == o2.getName().length()) ? 0 : 1);

            }
        });
        return userList;
    }

    public static List<User> sortByAllFields(List<User> userList) {
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                final int rsl = o1.getName().compareTo(o2.getName());
                return rsl != 0 ? rsl : o1.getAge().compareTo(o2.getAge());
            }
        });
        return userList;
    }
}
