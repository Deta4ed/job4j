package ru.job4j.enumerator;

public class Enumerator {
    private int scorer = 0;

    public void add() {
        scorer++;
    }

    public int get() {
        return scorer;
    }
}
