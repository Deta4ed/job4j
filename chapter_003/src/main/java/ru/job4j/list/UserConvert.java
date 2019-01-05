package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserConvert {

    public static HashMap<Integer, User> process(List<User> list) {
        return list.stream().collect(Collectors.toMap(User::getId, user -> user, (a, b) -> b, HashMap::new));
    }
}
