package ru.job4j.stream;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BiteStreamTest {

    @Test
    public void whenInEvenThenResultTrue() {
        BiteStream biteStream = new BiteStream();
        assertThat(biteStream.isNumber(new ByteArrayInputStream("22".getBytes())), is(true));
    }

    @Test
    public void whenEvenNumberIsNotExistsResultFalse() {
        BiteStream biteStream = new BiteStream();
        assertThat(biteStream.isNumber(new ByteArrayInputStream("25".getBytes())), is(false));
    }
}