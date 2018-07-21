package ru.job4j.departments;

import java.util.*;

/**
 * Departments.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Departments {

    /**
     *
     * @param source - original list depatments.
     * @return - full list depatments.
     */
    private TreeSet<String> supplement(List<String> source) {
        TreeSet<String> result = new TreeSet<>();
        for (String line : source) {
            int index = line.length();
            do {
                line = line.substring(0, index);
                result.add(line);
                index = line.lastIndexOf("\\");
            } while (index != -1);
        }
        return result;
    }

    /**
     *
     * @param source - original list depatments.
     * @return - sorted list in ascending of the departments.
     */
        public TreeSet<String> sortedAscending(List<String> source) {
        return supplement(source);
    }

    /**
     *
     * @param source - original list depatments.
     * @return - sorted list on diminution of the departments.
     */
    public TreeSet<String> sortedDiminution(List<String> source) {
        TreeSet<String> result = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length() && o1.startsWith(o2)) {
                    return 1;
                }
                return o2.compareTo(o1);
            }
        });
        result.addAll(supplement(source));
        return result;
    }
}
