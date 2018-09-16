package ru.job4j.store;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreTest {
    Store store = new Store();
    List<Store.User> oldList = new ArrayList<>();
    List<Store.User> newList = new ArrayList<>();

    @Test
    public void whenStoreTestThenChange() {
        HashMap result = store.info(oldList, newList);
        assertThat(result.get("Add"), is(0));
        assertThat(result.get("Change"), is(0));
        assertThat(result.get("Delete"), is(0));
    }
}