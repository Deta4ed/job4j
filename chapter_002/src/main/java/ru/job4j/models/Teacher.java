package ru.job4j.models;

/**
 * Teacher.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Teacher extends Profession {

    public Teacher() {
    }

    public Teacher(String name, String caling) {
        super(name, caling);
    }

    public String teach(Student student) {
        return "lesson learned";
    }
}
