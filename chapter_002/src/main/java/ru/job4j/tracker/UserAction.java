package ru.job4j.tracker;

/**
 * UserAction interface.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public interface UserAction {
    public int key();
    public void execute(Input input, Tracker tracker);
    public String info();
}
