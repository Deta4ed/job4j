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

    public String ask(String question) {
        return this.value[this.position++];
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.value[this.position++]);
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range.");
        }
        return key;
    }
}
