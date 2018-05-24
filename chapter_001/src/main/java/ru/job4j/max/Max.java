package ru.job4j.max;

/**
 * Max.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Max {

    /**
     * @param first - first.
     * @param second - second.
     * @return - max.
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    /**
     *
     * @param first - first.
     * @param second - second.
     * @param third - third.
     * @return - max.
     */
    public int max(int first, int second, int third) {
        int result = this.max(first, second);
        result = this.max(result, third);
        return result;
    }
}
