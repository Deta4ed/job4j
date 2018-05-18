package ru.job4j.array;


import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int[] rst = new Square().calculate(3);
        int[] expect = {1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound0Then0() {
        int[] rst = new Square().calculate(0);
        int[] expect = new int[0];
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound4Then14916() {
        int[] rst = new Square().calculate(4);
        int[] expect = {1, 4, 9, 16};
        assertThat(rst, is(expect));
    }

}
