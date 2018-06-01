package ru.job4j.tracker;

/**
 * interface Input.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
