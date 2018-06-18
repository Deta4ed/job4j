package ru.job4j.parser;

import ru.job4j.ArraySort;

import java.util.Arrays;

public class ParserBrace {
    private final Pair pair;

    public ParserBrace(Pair pair) {
        this.pair = pair;
    }

    /**
     * Parcer.
     * @param str
     * @return - array of all pairs of parentheses with positions.
     */
    public int[][] parcer(String str) {
        return this.validate(
            this.fallowing(
                this.decompression(
                    this.getArrayAllElements(
                            str.toCharArray()
                    )
                )
            )
        );
    }

    /**
     * Validate.
     * @param source - array of paired braces.
     * @return - array of all pairs of parentheses with positions.
     */
    private int[][] validate(int[][] source) {
        int count = 0;
        boolean valid;
        int[][] result = new int[source.length][2];
        for (int i = 0; i != source.length; i++) {
            valid = true;
            for (int j = 0; j != source.length; j++) {
                if (source[i][0] < source[j][0]
                        && source[i][1] < source[j][1]
                        && source[i][1] > source[j][0]
                        || source[i][0] > source[j][0]
                        && source[i][1] > source[j][1]
                        && source[i][0] < source[j][1]) {
                    valid = false;
                }
            }
            if (valid) {
                result[count][0] = source[i][0];
                result[count][1] = source[i][1];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     *
     * @param covers - array of arrays by signs.
     * @return - array of paired braces.
     */
    private int[][] fallowing(int[][] covers) {
        int count = 0;
        for (int index = 0; index != covers.length; index++) {
            count += covers[index].length;
        }
        int need = count / 2;
        int[][] result = new int[need][2];
        count = 0;
        for (int index = 0; index != pair.getTarget().length; index++) {
            for (int i = 0; i != covers[index + index].length; i++) {
                for (int j = 0; j != covers[index + index + 1].length; j++) {
                    if (covers[index + index][i] < covers[index + index + 1][j]) {
                        result[count][0] = covers[index + index][i];
                        result[count][1] = covers[index + index + 1][j];
                        covers[index + index + 1][j] = 0;
                        count++;
                        break;
                    }
                }
            }
        }
        return Arrays.copyOf(result, count);
    }

    /**
     * Parses an array of occurrences of arrays in brackets.
     * @param source - array of all occurrences.
     * @return - array of arrays by signs.
     */
    private int[][] decompression(int[][] source) {
        int[][] result = new int[pair.getTarget().length * pair.getTarget()[0].length][];
        for (int index = 0; index != pair.getTarget().length; index++) {
            int[] i = new int[source.length];
            int[] j = new int[source.length];
            int countI = 0;
            int countJ = 0;
            for (int count = 0; count != source.length; count++) {
                if (source[count][0] == index + index) {
                    i[countI] = source[count][1];
                    countI++;
                }
                if (source[count][0] == index + index + 1) {
                    j[countJ] = source[count][1];
                    countJ++;
                }
            }
            result[index + index] = ArraySort.sortArray(Arrays.copyOf(i, countI), -1);
            result[index + index + 1] = ArraySort.sortArray(Arrays.copyOf(j, countJ), 1);
        }
        return result;
    }

    /**
     * Parses an array of all occurrences.
     * @param source - char array.
     * @return - array of all occurrences.
     */
    private int[][] getArrayAllElements(char[] source) {
        int[][] result = new int[source.length + 1][2];
        int count = 0;
        for (int index = 0; index != source.length; index++) {
            for (int j = 0; j != pair.getTarget().length; j++) {
                for (int i = 0; i != pair.getTarget()[0].length; i++) {
                    if (source[index] == pair.getTarget()[j][i]) {
                        result[count][0] = i + j + j;
                        result[count][1] = index;
                        count++;
                    }
                }
            }
        }
        return Arrays.copyOf(result, count);
    }
}