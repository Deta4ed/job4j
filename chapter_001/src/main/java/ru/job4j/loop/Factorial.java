package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Factorial {

    /**
     *
     * @param n - number.
     * @return - factorial.
     */
    public int calc(int n) {
        int result = 1;
        if (n < 0) {
            return -1;
        }
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
        }
        return  result;
    }
}
