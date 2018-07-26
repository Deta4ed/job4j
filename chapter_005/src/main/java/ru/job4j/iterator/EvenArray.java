package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenArray.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class EvenArray implements Iterable {
    private final int[] numbers;

    public EvenArray(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator iterator() {
        return new EvenArrayIterator();
    }

    class EvenArrayIterator implements Iterator {
        private int index = -1;
        private boolean init = false;

        private int hasNextEvenNumbersIndex() {
            int result = -1;
            for (int i = index + 1; i != numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    result = i;
                    break;
                }
            }
            return result;
        }

        @Override
        public boolean hasNext() {
            if (!init) {
                index = hasNextEvenNumbersIndex();
                init = true;
            }
            return index != -1;
        }

        @Override
        public Object next() {
            if (!init) {
                index = hasNextEvenNumbersIndex();
                init = true;
            }
            if (index == -1) {
                throw new NoSuchElementException();
            }
            int result = numbers[index];
            index = hasNextEvenNumbersIndex();
            return result;
        }
    }
}
