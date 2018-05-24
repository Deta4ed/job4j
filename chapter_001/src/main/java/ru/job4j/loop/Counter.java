package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Counter {

    /**
     *
     * @param start - start.
     * @param finish - finish.
     * @return - сумма четных чисел.
     */
    public int add(int start, int finish) {
        int result = 0;
        for (int index = start; index <= finish; index++) {
            if (index % 2 == 0) {
                result = result + index;
            }
        }
        return result;
    }

    /**
     *
     * @param start - start.
     * @param finish - finish.
     * @return - сумма четных чисел.
     */
    public int add1(int start, int finish) {
        int result = 0;
        while (start <= finish) {
            if (start % 2 == 0) {
                result = result + start;
            }
            start++;
        }
        return result;
    }
}
