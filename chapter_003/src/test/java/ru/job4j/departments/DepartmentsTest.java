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
        depatments = new ArrayList<>();
        depatments.add("K3\\SK1\\SSK1");
        depatments.add("K1\\SK2");
        depatments.add("K1\\SK1\\SSK1");
        depatments.add("K1\\SK1\\SSK2");
        depatments.add("K2\\SK1\\SSK1");
        depatments.add("K2\\SK1\\SSK2");
    }

    @Test
    public void whenSortingInDescending() {
        List<String> expect = new ArrayList<>();
        expect.add("K3");
        expect.add("K3\\SK1");
        expect.add("K3\\SK1\\SSK1");
        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK2");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K1");
        expect.add("K1\\SK2");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK1\\SSK1");
        TreeSet<String> result = new Departments().sortedDiminution(this.depatments);
        assertThat(expect, contains(result.toArray()));
    }

    @Test
    public void whenSortingInAscending() {
        List<String> expect = new ArrayList<>();
        expect.add("K1");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK2");
        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K2\\SK1\\SSK2");
        expect.add("K3");
        expect.add("K3\\SK1");
        expect.add("K3\\SK1\\SSK1");

        TreeSet<String> result = new Departments().sortedAscending(this.depatments);
        assertThat(expect, contains(result.toArray()));
    }
}
