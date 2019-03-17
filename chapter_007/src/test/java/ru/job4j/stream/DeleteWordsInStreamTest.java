package ru.job4j.stream;

import org.junit.Test;
import java.io.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DeleteWordsInStreamTest {
    @Test
    public void whenRemoveWordsFromStreamThenDeleted() {
        DeleteWordsInStream deleteWordsInStream = new DeleteWordsInStream();
        String strInput = "Когда удаляем \n"
                + "лишние слова \n"
                + "из входящего потока";
        String strOutput = String.format("%s%n%s%n%s%n", "Когда удаляем ", "слова ", "из  потока");
        String[] abuses = {"лишние ", "входящего"};
        InputStream in = new ByteArrayInputStream(strInput.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        deleteWordsInStream.dropAbuses(in, out, abuses);
        assertThat(strOutput, is(out.toString()));
    }
}

