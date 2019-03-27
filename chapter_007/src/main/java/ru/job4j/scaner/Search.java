package ru.job4j.scaner;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Search.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Search {

    public List<File> files(String parent, List<String> exts) {
        return exts.stream().flatMap(
                s -> getAllFiles(parent).stream().filter(
                        f -> f.getName().startsWith(s, f.getName().length() - s.length())
                )
        ).collect(Collectors.toList());
    }

    private List<File> getAllFiles(String parent) {
        ArrayList<File> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        File item;
        while (!queue.isEmpty()) {
            item = queue.poll();
            if (item != null && item.isDirectory()) {
                queue.addAll(Arrays.asList(item.listFiles()));
            } else {
                result.add(item);
            }
        }
        return result;
    }
}
