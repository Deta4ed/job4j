package ru.job4j.iterator;

import java.util.Iterator;

/**
 * Converter.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> currentIt = it.next();

            private void addCurrentIt() {
                if (!currentIt.hasNext()) {
                    while (it.hasNext()) {
                        currentIt = it.next();
                        if (currentIt.hasNext()) {
                            break;
                        }
                    }
                }
            }

            @Override
            public boolean hasNext() {
                addCurrentIt();
                return currentIt.hasNext();
            }

            @Override
            public Integer next() {
                addCurrentIt();
                return currentIt.next();
            }
        };
    }
}
