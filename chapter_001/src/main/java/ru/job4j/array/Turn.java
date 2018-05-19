package ru.job4j.array;

/**
 * Turn.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Turn {

    /**
     *
     * @param array - array.
     * @return - turn array.
     */
    public int[] back(int[] array) {
        int temp;
        //int leght = array.length % 2 == 0 ? array.length / 2 : (array.length - 1) / 2;
        int leght = (int) array.length / 2;
        for (int index = 0; index < leght; index++) {
            temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;
        }
        return array;
    }
}
