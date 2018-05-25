package ru.job4j.models;

/**
 * Patient.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Patient {
    private String name;

    public Patient() {
    };

    public Patient(String name) {
        this.name = name;
    }

    /**
     * getName.
     * @return - name.
     */
    public String getName() {
        return name;
    }
}