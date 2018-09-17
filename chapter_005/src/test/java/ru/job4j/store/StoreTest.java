package ru.job4j.store;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreTest {

    @Test
    public void whenStoreTestThenChange() {
        List<Store.User> oldList = new ArrayList<>();
        List<Store.User> newList = new ArrayList<>();
        oldList.add(new Store.User(0, "Mike"));
        oldList.add(new Store.User(1, "Petr"));
        oldList.add(new Store.User(2, "Denil"));
        oldList.add(new Store.User(3, "Bruce"));
        oldList.add(new Store.User(4, "Dave"));
        oldList.add(new Store.User(5, "Steve"));
        oldList.add(new Store.User(6, "Max"));
        newList.add(new Store.User(0, "Mike"));
        newList.add(new Store.User(4, "Dave"));
        newList.add(new Store.User(1, "Denil"));
        newList.add(new Store.User(2, "Petr"));
        newList.add(new Store.User(3, "Bruce"));
        newList.add(new Store.User(7, "Max"));
        newList.add(new Store.User(8, "Jon"));
        HashMap result = new Store().info(oldList, newList);
        assertThat(result.get("Add"), is(2));
        assertThat(result.get("Change"), is(2));
        assertThat(result.get("Delete"), is(2));
    }
}