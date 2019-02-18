package ru.job4j.stream;

import java.io.*;

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
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String s : abuse) {
                    line = line.replaceAll(s, "");
                }
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
