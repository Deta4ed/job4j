package ru.job4j.models;

/**
 * Engineer.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Engineer extends Profession {

    public Engineer() {
    }

    public Engineer(String name, String caling) {
        super(name, caling);
    }

    /**
     * build.
     * @return - result.
     */
    public String build(House house) {
        return "house is built";
    }
}
