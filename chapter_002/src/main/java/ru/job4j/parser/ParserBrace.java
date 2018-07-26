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
     * @param str - source string.
     * @return - array of all pairs of parentheses with positions.
     */
    public List<int[]> parcer(String str) {
        List<int[]> list = new ArrayList<>();
        Stack<Character> stackChar = new Stack<Character>();
        Stack<Integer> stackNumeric = new Stack<Integer>();
        Stack<Character> deletedBrace = new Stack<Character>();
        for (int index = 0; index != str.length(); index++) {
            for (int j = 0; j != pair.getTarget().length; j++) {
                char symbol = str.charAt(index);
                if (symbol == pair.getTarget()[j][0]) {
                    stackChar.push(symbol);
                    stackNumeric.push(index);
                } else if (symbol == pair.getTarget()[j][1] && !stackChar.empty()) {
                    if (stackChar.peek() == pair.getTarget()[j][0]) {
                        list.add(new int[]{stackNumeric.pop(), index});
                        stackChar.pop();
                    } else {
                        if (!deletedBrace.removeElement(pair.getTarget()[j][0]) && stackChar.contains(pair.getTarget()[j][0])) {
                            while (stackChar.peek() != pair.getTarget()[j][0]) {
                                deletedBrace.push(stackChar.pop());
                                stackNumeric.pop();
                            }
                            stackChar.pop();
                            stackNumeric.pop();
                        }
                    }
                }
            }
        }
        return list;
    }
}