package ru.job4j.array;

/**
 * Square.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class FindLoop {

    /**
     *
     * @param data - массив элементов примитивного типа int.
     * @param el - элемент который ищем.
     * @return  - индекс элемента, если не найден -1.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
