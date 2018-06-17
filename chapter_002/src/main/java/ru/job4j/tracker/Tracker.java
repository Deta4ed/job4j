package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Tracker.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Tracker {
    private final List<Item> itemsList = new ArrayList<>();
    private static final Random RN = new Random(100);
    public boolean actual = true;

    /**
     * add item.
     * @param item - item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        //this.items[this.position++] = item;
        itemsList.add(item);
        return item;
    }

    /**
     * replace item.
     * @param id - id.
     * @param item - item.
     */
    public void replace(String id, Item item) {
        for (Item current : this.itemsList) {
            if (current.getId().equals((id))) {
                itemsList.remove(current);
                itemsList.add(item);
                break;
            }
        }
    }

    /**
     * deleted item.
     * @param id - id.
     */
    public void delete(String id) {
        for (Item current : this.itemsList) {
            if (current.getId().equals((id))) {
                itemsList.remove(current);
                break;
            }
        }
    }

    /**
     * return all items.
     * @return array items.
     */
    public List<Item> getAll() {
        return this.itemsList;
    }

    /**
     *
     * findByName.
     * @param key - name.
     * @return - array items.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.itemsList) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     *
     * findById.
     * @param id - id.
     * @return item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.itemsList) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     *
     * generete id
     * @return id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
