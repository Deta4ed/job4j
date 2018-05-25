package ru.job4j.models;

/**
 * Doctor.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Doctor extends Profession {

    public Doctor() {
    }

    public Doctor(String name, String caling) {
        super(name, caling);
    }

    /**
     * heal.
     * @param patient - patient.
     * @return - diagnose.
     */
    public String heal(Patient patient) {
        //return this.getCaling() + " " + this.getName() + " cured " + patient.getName();
        return caling + " " + name + " cured " + patient.getName();
    }
}
