package ru.job4j.calculator;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CalculatorTest.
 *
 * @author Vitaly Lobach (deta4ed@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * Test whenAddOnePlusOneThenTwo.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test whenAddTwoSubstructOneThenOne.
     */
    @Test
    public void whenAddTwoSubstructOneThenOne() {
        Calculator calc = new Calculator();
        calc.substruct(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test whenAddTwoDivTwoThenOne.
     */
    @Test
    public void whenAddTwoDivTwoThenOne() {
        Calculator calc = new Calculator();
        calc.div(2D, 2D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test whenAddTwoMultipleTwoThenFour.
     */
    @Test
    public void whenAddTwoMultipleTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
}
