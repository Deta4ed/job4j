package ru.job4j.coffee;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoffeeMachineTest {

    @Test
    public void whenSum50AndPrice17ThenSurrender33() {
        CoffeeMachine machine = new CoffeeMachine();
        assertThat(machine.changes(50, 17), is(new int[] {10, 10, 10, 2, 1}));
    }

    @Test
    public void whenSum50AndPrice17WithoutOneBanknotThenSurrender32() {
        CoffeeMachine machine = new CoffeeMachine(new int[] {2, 5, 10});
        assertThat(machine.changes(50, 17), is(new int[] {10, 10, 10, 2}));
    }
}
