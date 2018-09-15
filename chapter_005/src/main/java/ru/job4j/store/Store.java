package ru.job4j.store;

import java.util.HashMap;
import java.util.List;

/**
 * Store.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Store {

    public HashMap<String, Integer> info(List<User> previoues, List<User> current) {
        HashMap<String, Integer> result = new HashMap<>();
        int change = 0;
        HashMap<Integer, String> allElement = new HashMap<>();
        for (User user : current) {
            allElement.put(user.getId(), user.getName());
        }
        for (User user : previoues) {
            String currentUserName = allElement.get(user.getId());
            if (currentUserName != null && !user.getName().equals(currentUserName)) {
                change++;
            }
            allElement.put(user.getId(), user.getName());
        }
        result.put("Add", allElement.size() - previoues.size());
        result.put("Delete", allElement.size() - current.size());
        result.put("Change", change);

        return result;
    }

    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }
}