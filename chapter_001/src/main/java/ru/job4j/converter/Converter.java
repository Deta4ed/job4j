package ru.job4j.converter;

/**
 * Converter.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Converter {
    /**
     *  Convert ruble to euro.
     * @param value ruble.
     * @return euro.
     */
    public int rubleToEuro(int value) {
        int result = value / 70;
        return result;
    }

    /**
     *  Convert ruble to dollar.
     * @param value ruble.
     * @return dollar.
     */
    public int rubleToDollar(int value) {
        int result = value / 60;
        return result;
    }

    /**
     *  Convert euro to ruble.
     * @param value euro.
     * @return ruble.
     */
    public int euroToRuble(int value) {
        int result = value * 70;
        return result;
    }

    /**
     *  Convert dollar to ruble.
     * @param value dollar.
     * @return ruble.
     */
    public int dollarToRuble(int value) {
        int result = value * 60;
        return result;
    }
}
