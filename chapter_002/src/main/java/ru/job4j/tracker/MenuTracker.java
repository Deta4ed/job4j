package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MenuTracker.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
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
        this.actions[0] = new AddItem(0, "Add new Item");
        this.actions[1] = new ShowAllItems(1, "Show all items");
        this.actions[2] = new EditItem(2, "Edit item");
        this.actions[3] = new DeleteItem(3, "Delete item");
        this.actions[4] = new FindById(4, "Find item by Id");
        this.actions[5] = new FindByName(5, "Find items by name");
        this.actions[6] = new ExitProgram(6, "Exit Program");
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
    private static class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
                System.out.println("--------------- Adding a new request -----------------");
                Item item = createItem(input);
                tracker.add(item);
                System.out.println("--------- New request with Id : " + item.getId() + " --------");
        }
    }

    /**
     * class ShowAllItems implementing the second menu item
     */
    private static class ShowAllItems extends BaseAction {

        public ShowAllItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            showItems(tracker.getAll());
        }
    }

    /**
     * class EditItem implementing the third menu item
     */
    private static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * class DeleteItem implementing the fourth menu item
     */
    private static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
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
    }

    /**
     * class FindById implementing the fifth menu item
     */
    private static class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Input the ID of the request for search :"));
            if (item != null) {
                showItems(new Item[] {item});
            } else {
                System.out.println("The request is not found!");
            }
        }
    }

    /**
     * class FindByName implementing the sixth menu item
     */
    private static class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findByName(input.ask("Input the name of the request for search :"));
            if (items.length != 0) {
                showItems(items);
            } else {
                System.out.println("The request is not found!");
            }
        }
    }

    /**
     * class ExitProgram implementing the seventh menu item
     */
    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            tracker.actual = false;
        }
    }
}
