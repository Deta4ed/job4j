package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private final String name;
    private int scope;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public String getName() {

        return name;
    }

    public int getScope() {
        return scope;
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted().takeWhile(v -> v.getScope() > bound).collect(Collectors.toList());
    }

    @Override
    public int compareTo(Student o) {
        final  int rsl = Integer.compare(o.scope, this.scope);
        return rsl != 0 ? rsl : this.name.compareTo(o.name);
    }
}
