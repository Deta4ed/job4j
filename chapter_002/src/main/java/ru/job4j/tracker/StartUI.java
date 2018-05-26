package ru.job4j.tracker;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * StartUI.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class StartUI {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * ShowMenu.
     */
    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * CreateItem.
     * @return - create request without id.
     */
    private Item createItem() {
        String name = this.input.ask("Input the name of the request :");
        String desc = this.input.ask("Input the description of the request :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        return item;
    }

    /**
     * Add request to tracker.
     */
    private void addItem() {
        System.out.println("--------------- Adding a new request -----------------");
        Item item = this.createItem();
        this.tracker.add(item);
        System.out.println("--------- New request with Id : " + item.getId() + " --------");
    }

    /**
     * Show all items.
     * @param items - array items.
     */
    private void showItems(Item[] items) {
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
     * Editing request by id
     */
    private void editItem() {
        String currentID = this.input.ask("Input the ID of the request for edit :");
        Item findItem = this.tracker.findById(currentID);
        if (findItem != null) {
            System.out.println("------------------ Edit request --------------------");
            Item item = this.createItem();
            this.tracker.replace(currentID, item);
            item.setId(currentID);
            System.out.println("------- request saved with ID : " + item.getId() + "-------");
        } else {
            System.out.println("The request for editing is not found!");
        }
    }

    /**
     * Deleting request by id.
     */
    private void deletedItem() {
        String currentID = this.input.ask("Input the ID of the request for delete :");
        Item findItem = this.tracker.findById(currentID);
        if (findItem != null) {
            this.tracker.delete(currentID);
            System.out.println("---- request with ID : " + currentID + " was deleted ----");
        } else {
            System.out.println("The request for deletion is not found!");
        }
    }

    /**
     * Repit action.
     * @param version - action type.
     */
    private void tryAgain(int version) {
        System.out.println("The request is not found!");
        String answer = this.input.ask("try again? (y/n) :");
        if (answer.equals("y") || answer.equals("Y")) {
            if (version == 1) {
            this.findByName();
            } else if (version == 2) {
                this.findByID();
            }
        } else if (!(answer.equals("n") || !answer.equals("N"))) {
            this.tryAgain(version);
        }
    }

    /**
     * Search requet by ID.
     */
    private void findByID() {
        Item item = this.tracker.findById(this.input.ask("Input the ID of the request for search :"));
        if (item != null) {
            this.showItems(new Item[] {item});
        } else {
            this.tryAgain(2);
        }
    }

    /**
     * Search requet by name.
     */
    private void findByName() {
        Item[] items = this.tracker.findByName(this.input.ask("Input the name of the request for search :"));
        if (items.length != 0) {
            this.showItems(items);
        } else {
            this.tryAgain(1);
        }
    }

    /**
     * Initialization.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Select: ");
            if (ADD.equals(answer)) {
                this.addItem();
            } else if (SHOW.equals(answer)) {
                this.showItems(this.tracker.getAll());
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deletedItem();
            } else if (FINDID.equals(answer)) {
                this.findByID();
            } else if (FINDNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
