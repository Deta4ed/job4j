package ru.job4j.parser;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

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
    public List<int[]> parcer(String str) {
        return this.validate(
            this.fallowing(
                this.decompression(
                    this.getAllElements(
                            str.toCharArray()
                    )
                )
            )
        );
    }

    /**
     * Validate.
     * @param source - array of paired braces.
     * @return - list of all pairs of parentheses with positions.
     */
    private List<int[]> validate(List<int[]> source) {
        List<int[]> result = new ArrayList<>();
        boolean valid;
        for (int[] braceOne : source) {
            valid = true;
            for (int[] braceTwo : source) {
                if (braceOne[0] < braceTwo[0]
                        && braceOne[1] < braceTwo[1]
                        && braceOne[1] > braceTwo[0]
                        || braceOne[0] > braceTwo[0]
                        && braceOne[1] > braceTwo[1]
                        && braceOne[0] < braceTwo[1]) {
                    valid = false;
                }
            }
            if (valid) {
                result.add(braceOne);
            }
        }
        return result;
    }

    /**
     *
     * @param covers - array of arrays by signs.
     * @return - list of paired braces.
     */
    private List<int[]> fallowing(Stack<Integer>[] covers) {
        List<int[]> list = new ArrayList<>();
        for (int index = 0; index != pair.getTarget().length; index++) {
            while (!covers[index + index].empty()) {
                boolean exist = false;
                for (Integer cell : covers[index + index + 1]) {
                    if (!covers[index + index].empty() && covers[index + index].peek() < cell) {
                        list.add(new int[]{covers[index + index].pop(), cell});
                        covers[index + index + 1].removeElement(cell);
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    covers[index + index].pop();
                }
            }
        }
        return list;
    }

    /**
     * Parses an array of occurrences of arrays in brackets.
     * @param source - array of all occurrences.
     * @return - stacks by signs.
     */
    private Stack<Integer>[] decompression(List<int[]> source) {
        @SuppressWarnings("unchecked")
        Stack<Integer>[] result = (Stack<Integer>[]) new Stack[pair.getTarget().length * pair.getTarget()[0].length];
        for (int index = 0; index != result.length; index++) {
            result[index] = new Stack<Integer>();
        }
        for (int[] brace : source) {
            result[brace[0]].add(brace[1]);
        }
        return result;
    }

    /**
     * Parses an array of all occurrences.
     * @param source - char array.
     * @return - list of all occurrences.
     */
    private List<int[]> getAllElements(char[] source) {
        List<int[]> list = new ArrayList<>();
        for (int index = 0; index != source.length; index++) {
            for (int j = 0; j != pair.getTarget().length; j++) {
                for (int i = 0; i != pair.getTarget()[0].length; i++) {
                    if (source[index] == pair.getTarget()[j][i]) {
                        list.add(new int[] {i + j + j, index});
                    }
                }
            }
        }
        return list;
    }
}