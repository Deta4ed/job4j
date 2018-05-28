package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions;
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.actions = new UserAction[7];
        this.init();
    }

    /**
     * Initialization.
     */
    private void init() {
        this.actions[0] = new AddItem();
        this.actions[1] = new ShowAllItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindById();
        this.actions[5] = new FindByName();
        this.actions[6] = new ExitProgram();
    }

    /**
     *  select - executes the menu item.
     * @param key - index menu item in array actions.
     */

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * ShowMenu - show all items menu.
     */
    public void showMenu() {
        System.out.println("Menu:");
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * CreateItem.
     * @return - create request without id.
     */
    private static Item createItem(Input input) {
        String name = input.ask("Input the name of the request :");
        String desc = input.ask("Input the description of the request :");
        return new Item(name, desc, System.currentTimeMillis());
    }

    /**
     * Show all items.
     * @param items - array items.
     */
    private static void showItems(Item[] items) {
        for (Item item : items) {
            System.out.println("");
            System.out.println("------------ Request ID : " + item.getId() + " --------------");
            System.out.println("Create :      " + FORMAT.format(new Date(item.getCreate())));
            System.out.println("Name :        " + item.getName());
            System.out.println("Description : " + item.getDescription());
            System.out.println("------------------------------------------------------");
        }
    }

    /**
     * class AddItem implementing the first menu item
     */
    private static class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
                System.out.println("--------------- Adding a new request -----------------");
                Item item = createItem(input);
                tracker.add(item);
                System.out.println("--------- New request with Id : " + item.getId() + " --------");
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add new Item");
        }
    }

    /**
     * class ShowAllItems implementing the second menu item
     */
    private static class ShowAllItems implements UserAction {

        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            showItems(tracker.getAll());
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    /**
     * class EditItem implementing the third menu item
     */
    private static class EditItem implements UserAction {

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String currentID = input.ask("Input the ID of the request for edit :");
            Item findItem = tracker.findById(currentID);
            if (findItem != null) {
                System.out.println("------------------ Edit request --------------------");
                Item item = createItem(input);
                tracker.replace(currentID, item);
                item.setId(currentID);
                System.out.println("------- request saved with ID : " + item.getId() + "-------");
            } else {
                System.out.println("The request for editing is not found!");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    /**
     * class DeleteItem implementing the fourth menu item
     */
    private static class DeleteItem implements UserAction {

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            String currentID = input.ask("Input the ID of the request for delete :");
            Item findItem = tracker.findById(currentID);
            if (findItem != null) {
                tracker.delete(currentID);
                System.out.println("---- request with ID : " + currentID + " was deleted ----");
            } else {
                System.out.println("The request for deletion is not found!");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Delete item");
        }
    }

    /**
     * class FindById implementing the fifth menu item
     */
    private static class FindById implements UserAction {

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Input the ID of the request for search :"));
            if (item != null) {
                showItems(new Item[] {item});
            } else {
                System.out.println("The request is not found!");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }
    }

    /**
     * class FindByName implementing the sixth menu item
     */
    private static class FindByName implements UserAction {

        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findByName(input.ask("Input the name of the request for search :"));
            if (items.length != 0) {
                showItems(items);
            } else {
                System.out.println("The request is not found!");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }

    /**
     * class ExitProgram implementing the seventh menu item
     */
    private class ExitProgram implements UserAction {

        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
            tracker.actual = false;
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Exit Program");
        }
    }
}
