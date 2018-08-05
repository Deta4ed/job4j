package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CycleTest {
    private Cycle<String> cycle = new Cycle<String>();
    private Cycle.Node one = cycle.new Node<String>();
    private Cycle.Node two = cycle.new Node<String>();
    private Cycle.Node three = cycle.new Node<String>();
    private Cycle.Node four = cycle.new Node<String>();
    private Cycle.Node five = cycle.new Node<String>();
    private Cycle.Node six = cycle.new Node<String>();
    private Cycle.Node seven = cycle.new Node<String>();
    private Cycle.Node eight = cycle.new Node<String>();
    private Cycle.Node nine = cycle.new Node<String>();

    @Before
    public void init() {
        one.value = "one";
        two.value = "two";
        three.value = "three";
        four.value = "four";
        five.value = "five";
        six.value = "six";
        seven.value = "seven";
        eight.value = "eight";
        nine.value = "nine";
    }

    @Test
    public void whenListNotClosed() {
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = null;
        assertThat(cycle.hasCycle(one), is(false));
    }

    @Test
    public void whenListClosedInMiddle() {
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = three;
        seven.next = eight;
        eight.next = nine;
        nine.next = null;
        assertThat(cycle.hasCycle(one), is(true));
    }

    @Test
    public void whenListClosedAtTheEnd() {
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = one;
        assertThat(cycle.hasCycle(one), is(true));
    }
}