package ru.job4j.tracker;

/**
 * BaseAction.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    protected BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
