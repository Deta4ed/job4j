package ru.job4j.tracker;

/**
 * StubInput.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class StubInput implements Input {
    private final String[] value;
    private int position = 0;

    public StubInput(String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
