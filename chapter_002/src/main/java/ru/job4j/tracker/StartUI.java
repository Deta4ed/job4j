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
            String answer = this.input.ask("Select: ");
            menu.select(Integer.valueOf(answer));
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
