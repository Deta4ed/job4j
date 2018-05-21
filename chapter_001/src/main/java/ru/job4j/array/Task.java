package ru.job4j.array;

/**
 * ArrayChar.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Task {

    /**
     *
     * @param one - one array.
     * @param two - two array.
     * @return - combining sort array.
     */
    public int[] combiningArray(int[] one, int[] two) {
        int[] array = new int[one.length + two.length];
        int pozitionOne = 0; int pozitionTwo = 0;
        for (int index = 0; index < array.length; index++) {
            if (pozitionOne == one.length) {
                array[index] = two[pozitionTwo];
                pozitionTwo++;
            } else if (pozitionTwo == two.length) {
                array[index] = one[pozitionOne];
                pozitionOne++;
            } else {
                if (one[pozitionOne] < two[pozitionTwo]) {
                    array[index] = one[pozitionOne];
                    pozitionOne++;
                } else {
                    array[index] = two[pozitionTwo];
                    pozitionTwo++;
                }
            }
        }
        return array;
    }
}
