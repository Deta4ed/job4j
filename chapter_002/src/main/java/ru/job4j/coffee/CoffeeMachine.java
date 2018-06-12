package ru.job4j.coffee;

import ru.job4j.ArraySort;

/**
 * CoffeeMachine.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class CoffeeMachine {
    private final int[] raiting;
    private final int index = 0;

    public CoffeeMachine() {
        this.raiting = new int[] {10, 5, 2, 1};
    }

    public CoffeeMachine(final int[] raiting) {
        this.raiting = ArraySort.sortArray(raiting, -1);
    }

    /**
     *
     * @param value - amount.
     * @param price - price.
     * @return - returnable banknote array.
     */
    public int[] changes(int value, int price) {
        int[] result = new int[getCount(value - price, this.index)];
        getChange(result, value - price, this.index, this.index);
        return result;
    }

    /**
     *
     * @param result - fill array.
     * @param value - amount for return.
     * @param index - index in a returnable banknote array.
     * @param position - position in a raiting banknote array.
     */
    private void getChange(int[] result, int value, int index, int position) {
        if (value > 0 && value >= raiting[raiting.length - 1]) {
            for (int p = 0; p != value / raiting[position]; p++) {
                result[index + p] = raiting[position];
            }
            getChange(result, value - raiting[position] * (value / raiting[position]), index + value / raiting[position], ++position);
        }
    }

    /**
     *
     * @param value - amount for return.
     * @param index - index in a raiting banknote array.
     * @return - size to create an array.
     */
    private int getCount(int value, int index) {
        if (value <= 0 || value < raiting[raiting.length - 1]) {
            return  0;
        }
        return value / raiting[index] + getCount(value - raiting[index] * (value / raiting[index]), ++index);
    }
}
