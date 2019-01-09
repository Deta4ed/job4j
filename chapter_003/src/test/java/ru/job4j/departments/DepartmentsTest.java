package ru.job4j.departments;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    public List<String> depatments;

    @Before
    public void ininDepatments() {
        depatments = List.of(
        "K3\\SK1\\SSK1",
        "K1\\SK2",
        "K1\\SK1\\SSK1",
        "K1\\SK1\\SSK2",
        "K2\\SK1\\SSK1",
        "K2\\SK1\\SSK2");
    }

    @Test
    public void whenSortingInDescending() {
        List<String> expect = List.of(
        "K3",
        "K3\\SK1",
        "K3\\SK1\\SSK1",
        "K2",
        "K2\\SK1",
        "K2\\SK1\\SSK2",
        "K2\\SK1\\SSK1",
        "K1",
        "K1\\SK2",
        "K1\\SK1",
        "K1\\SK1\\SSK2",
        "K1\\SK1\\SSK1");
        TreeSet<String> result = new Departments().sortedDiminution(this.depatments);
        assertThat(expect, contains(result.toArray()));
    }

    @Test
    public void whenSortingInAscending() {
        List<String> expect = List.of(
        "K1",
        "K1\\SK1",
        "K1\\SK1\\SSK1",
        "K1\\SK1\\SSK2",
        "K1\\SK2",
        "K2",
        "K2\\SK1",
        "K2\\SK1\\SSK1",
        "K2\\SK1\\SSK2",
        "K3",
        "K3\\SK1",
        "K3\\SK1\\SSK1");
        TreeSet<String> result = new Departments().sortedAscending(this.depatments);
        assertThat(expect, contains(result.toArray()));
    }
}
