package ru.job4j.nonblock;

public class Base {
    private final int id;
    private String name;
    private int version;

    public Base(final int id, String name) {
        this.id = id;
        this.name = name;
        version = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateVersion() {
        this.version++;
    }
}
