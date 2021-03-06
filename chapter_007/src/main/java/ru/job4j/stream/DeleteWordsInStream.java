package ru.job4j.stream;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * DeleteWordsInStream.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class DeleteWordsInStream {

    /**
     * This method deleted words in stream.
     *
     * @param in    stream with abuse word.
     * @param out   stream without abuse word.
     * @param abuse list of abuse words.
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));
             PrintStream writer = new PrintStream(out)) {
            reader.lines().map(s -> Arrays.stream(abuse).reduce(s, (s1, s2) -> s1.replaceAll(s2, ""))).forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
