package ru.job4j.array;

/**
 * BubbleSort.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class BubbleSort {

    /**
     *
     * @param array - array.
     * @return - sorted array.
     */
    public int[] sort(int[] array) {
        int temp, needed;
        int height = array.length;
        while (height != 0) {
            needed = height + 1 < array.length ? height + 1 : array.length - 1; height = 0;
            for (int index = 1; index <= needed; index++) {
                if (array[index] < array[index - 1]) {
                    temp = array[index - 1];
                    array[index - 1] = array[index];
                    array[index] = temp;
                    height = height < index ? index : height;
                }
            }
        }
        return array;
    }
}
