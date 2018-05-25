package ru.job4j.models;

/**
 * Profession.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Profession {
    protected String name;
    protected String caling;

    public Profession() {
    };

    public Profession(String name, String caling) {
        this.name = name;
        this.caling = caling;
    }

    /**
     * getName.
     * @return - name.
     */
    public String getName() {
        return name;
    }

    /**
     * getCaling.
     * @return - caling.
     */
    public String getCaling() {
        return caling;
    }
}
