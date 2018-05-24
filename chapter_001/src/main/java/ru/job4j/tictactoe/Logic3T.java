package ru.job4j.tictactoe;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
        boolean right = true;
        boolean left = true;
        boolean vertical = false;
        boolean horizontal = false;
        for (int out = 0; out < table.length; out++) {
            vertical = true; horizontal = true;
            right = right && table[out][table.length - 1 - out].hasMarkX();
            left = left && table[out][out].hasMarkX();
            for (int in = 0; in < table[0].length; in++) {
                horizontal = horizontal && table[out][in].hasMarkX();
                vertical = vertical && table[in][out].hasMarkX();
            }
            if (vertical || horizontal) {
                break;
            }
        }
        return (vertical || horizontal || right || left);
    }

    public boolean isWinnerO() {
        boolean right = true;
        boolean left = true;
        boolean vertical = false;
        boolean horizontal = false;
        for (int out = 0; out < table.length; out++) {
            vertical = true; horizontal = true;
            right = right && table[out][table.length - 1 - out].hasMarkO();
            left = left && table[out][out].hasMarkO();
            for (int in = 0; in < table[0].length; in++) {
                horizontal = horizontal && table[out][in].hasMarkO();
                vertical = vertical && table[in][out].hasMarkO();
            }
            if (vertical || horizontal) {
                break;
            }
        }
        return (vertical || horizontal || right || left);
    }

    public boolean hasGap() {
        boolean result = false;
        for (int out = 0; !result && out < table.length; out++) {
            for (int in = 0; in < table[0].length; in++) {
                if (!table[out][in].hasMarkX() && !table[out][in].hasMarkO()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
