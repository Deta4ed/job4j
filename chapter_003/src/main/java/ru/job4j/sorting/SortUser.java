package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public static Set<User> sort(List<User> userList) {
        Set<User> users = new TreeSet<>();
        users.addAll(userList);
        return users;
    }
}
