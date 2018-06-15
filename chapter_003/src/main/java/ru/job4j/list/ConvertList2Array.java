package ru.job4j.list;

import java.util.List;

/**
 * ConvertList2Array.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class ConvertList2Array {

    /**
     *
     * @param list - list.
     * @param rows - number of rows in the array.
     * @return - array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int j = 0; rows = 0; cells--;
        for (Integer item : list) {
            array[rows][j] = item;
            if (j == cells) {
                j = 0;
                rows++;
            } else {
                j++;
            }
        }
        return array;
    }
}
