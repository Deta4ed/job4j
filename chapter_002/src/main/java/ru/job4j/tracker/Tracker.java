package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return findBy(item -> item.getName().equals(key));
    }

    /**
     *
     * findById.
     * @param id - id.
     * @return item.
     */
    public Item findById(String id) {
        Item result = null;
        List<Item> items = findBy(item -> item.getId().equals(id));
        if (!items.isEmpty()) {
            result = items.get(0);
        }
        return result;
    }

    /**
     *
     * @param condition - predicate
     * @return - list items.
     */
    private List<Item> findBy(Predicate<Item> condition) {
        return this.itemsList.stream().filter(condition).collect(Collectors.toList());
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
