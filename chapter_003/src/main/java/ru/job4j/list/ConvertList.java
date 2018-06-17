package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertList.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class ConvertList {

    /**
     * @param list - array list.
     * @return  - common list.
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int cell : array) {
                result.add(cell);
            }
        }
        return result;
    }
}
