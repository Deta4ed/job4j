package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */

public class Calculator {
    private double result;

    /**
     * add.
     * @param first - first double.
     * @param second - second double.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * substruct.
     * @param first - first double.
     * @param second - second double.
     */
    public  void substruct(double first, double second) {
        this.result = first - second;
    }

    /**
     * div.
     * @param first - first double.
     * @param second - second double.
     */
    public  void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * multiple.
     * @param first - first double.
     * @param second - second double.
     */
    public  void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * getResult.
     *
     * @return - this.result.
     */
    public double getResult() {
        return this.result;
    }
}
