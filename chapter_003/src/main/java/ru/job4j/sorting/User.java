package ru.job4j.sorting;

public class User implements Comparable<User> {
    private final String name;
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(User o) {
        final int rsl = this.age.compareTo(o.getAge());
        return rsl != 0 ? rsl : this.name.compareTo(o.getName());
    }
}
