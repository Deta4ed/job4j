package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class ArrayDuplicate {

    /**
     *
     * @param array - array.
     * @return - array without duplicate.
     */
    public String[] remove(String[] array) {
        int border = array.length;
        for (int count = 0; count < border; count++) {
            for (int index = count + 1; index < border; index++) {
                if (array[count].equals(array[index])) {
                    array[index] = array [border - 1];
                    border--;
                    index--;
                }
            }
        }
        return Arrays.copyOf(array, border);
    }
}
