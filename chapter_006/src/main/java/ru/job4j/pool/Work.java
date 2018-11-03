package ru.job4j.pool;

public class Work implements Runnable {
    private final int index;

    public Work(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("Task - " + index + " thread - " + Thread.currentThread().getName());
    }

    public int getIndex() {
        return index;
    }
}
