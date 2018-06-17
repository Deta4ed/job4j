package ru.job4j.parser;

public class Pair {
    private final char[][] target;

    public Pair() {
        this.target = new char[][]{
                {'{', '}'},
                {'[', ']'},
                {'(', ')'}
        };
    }

    public Pair(char[][] target) {
        for (int i = 0; i != target.length; i++) {
            if (target[i].length != 2) {
                throw new ArrayStoreException("Invalid array format!");
            }
        }
        this.target = target;
    }

    public char[][] getTarget() {
        return target;
    }
}
