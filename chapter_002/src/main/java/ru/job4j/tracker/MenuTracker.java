package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;

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
    private List<UserAction> actions = new ArrayList<>();
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.init();
    }

    /**
     * Initialization.
     */
    private void init() {
        this.actions.add(new AddItem(0, "Add new Item"));
        this.actions.add(new ShowAllItems(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindById(4, "Find item by Id"));
        this.actions.add(new FindByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     *  select - executes the menu item.
     * @param key - key menu item in map actions.
     */

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * ShowMenu - show all items menu.
     */
    public void showMenu(Consumer<String> consumer) {
        consumer.accept("Menu:");
        for (UserAction action : this.actions) {
            if (action != null) {
                consumer.accept(action.info());
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
    private static void showItems(List<Item> items) {
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
                List<Item> result = new ArrayList<>();
                result.add(item);
                showItems(result);
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
            List<Item> items = tracker.findByName(input.ask("Input the name of the request for search :"));
            if (items.size() != 0) {
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
