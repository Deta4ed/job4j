package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskTest {

    @Test
    public void whenCombiningArrayThenSortedCombiningArray() {
        int[] one = {2, 5, 6, 8, 9, 15};
        int[] two = {1, 6, 7, 8, 9, 11, 12};
        Task task = new Task();
        int[] result = task.combiningArray(one, two);
        int[] expect = new int[] {1, 2, 5, 6, 6, 7, 8, 8, 9, 9, 11, 12, 15};
        assertThat(result, is(expect));
    }
}
