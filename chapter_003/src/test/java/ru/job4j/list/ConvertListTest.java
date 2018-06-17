package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {

    @Test
    public void whenListArrayInOneListThenList6() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = ConvertList.convert(list);
        List<Integer> expect = new ArrayList<>();
        expect.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result, is(expect));
    }
}
