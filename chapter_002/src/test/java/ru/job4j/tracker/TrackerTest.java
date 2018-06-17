package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 124L);
        Item item3 = new Item("test3", "testDescription", 125L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(item1, item2, item3));
        assertThat(tracker.getAll(), is(expect));
    }

    @Test
    public void whenReplaceItemThenTrackerHasSameItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 124L);
        Item item3 = new Item("test3", "testDescription", 125L);
        Item item4 = new Item("test4", "testDescription", 126L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(item1, item3, item4));

        tracker.replace(item2.getId(), item4);
        assertThat(tracker.getAll(), is(expect));
    }

    @Test
    public void whenDeletedItemThenTrackerHasSameItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 124L);
        Item item3 = new Item("test3", "testDescription", 125L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(item1, item3));
        tracker.delete(item2.getId());
        assertThat(tracker.getAll(), is(expect));
    }

    @Test
    public void whenFindByNameItemThenTrackerHasSameItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription", 124L);
        Item item3 = new Item("test1", "testDescription", 125L);
        Item item4 = new Item("test4", "testDescription", 126L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(item1, item2, item3));
        assertThat(tracker.findByName("test1"), is(expect));
    }

    @Test
    public void whenFindByIdItemThenTrackerHasSameItems() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test1", "testDescription", 124L);
        Item item3 = new Item("test1", "testDescription", 125L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById(item2.getId()), is(item2));
    }

}
