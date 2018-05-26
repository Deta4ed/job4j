package ru.job4j.tracker;

import java.util.Scanner;

/**
 * ConsoleInput.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);
    /**
     * ask.
     * @param question - question.
     * @return - answer.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
