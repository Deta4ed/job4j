package ru.job4j.tracker;

/**
 * StartUI.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private int[] range = new int[] {0, 1, 2, 3, 4, 5, 6};

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Initialization.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        while (this.tracker.actual) {
            menu.showMenu();
            menu.select(this.input.ask("Select: ", range));
        }
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
