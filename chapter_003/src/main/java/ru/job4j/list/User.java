package ru.job4j.list;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private final int id;
    private String name;
    private String city;

    public User(Integer id, String name, String city) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }

    public int getId() {
        return this.id;
    }
}
