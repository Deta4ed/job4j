package ru.job4j.enumerator;

public class ThreadDrive {
    public static void main(String[] args) {
        Runner runner = new Runner(new Enumerator());
        Thread one = new Thread(runner);
        Thread two = new Thread(runner);
        one.setName("One");
        two.setName("Two");
        one.start();
        two.start();
    }
}
