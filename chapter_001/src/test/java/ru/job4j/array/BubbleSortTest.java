package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * BubbleSort.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayThenSortedArray() {
        int[] input = new int[] {10, 2, 6, 4, 3, 8, 5, 7, 9, 1, 0};
        int[] result = new BubbleSort().sort(input);
        int[] expect = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
}
