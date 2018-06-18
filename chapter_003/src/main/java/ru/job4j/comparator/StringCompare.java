package ru.job4j.comparator;

import java.util.Comparator;

/**
 * StringCompare.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int leftLn = left.length();
        int rightLn = right.length();
        int limit = Math.min(leftLn, rightLn);
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        int result = 0;
        for (int index = 0; index != limit; index++) {
            if (leftArray[index] != rightArray[index]) {
                result = Character.compare(leftArray[index], rightArray[index]);
                break;
            }
        }
        return result != 0 ? result : Integer.compare(leftLn, rightLn);
    }
}
