package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

/**
 * ArrayDuplicateTest.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Привет", "Привет", "Супер", "Супер", "Мир", "Привет", "Супер", "Мир", "Мир", "Привет"};
        String[] result = new ArrayDuplicate().remove(input);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
