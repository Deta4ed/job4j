package ru.job4j;

public final class ArraySort {

    /**
     *
     * Bidirectional array sorting
     * @param array - source array.
     * @param direction - direction.
     * @return - sorted array.
     */
    public static int[] sortArray(int[] array, int direction) {
        int temp, needed;
        for (int height = array.length - 1; height != 0;) {
            needed = height + 1 < array.length ? height + 1 : array.length - 1; height = 0;
            for (int index = 1; index <= needed; index++) {
                if (direction < 0 ? array[index] > array[index - 1] : array[index] < array[index - 1]) {
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
