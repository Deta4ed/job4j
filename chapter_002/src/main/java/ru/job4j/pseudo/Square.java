package ru.job4j.pseudo;

/**
 * Class Square.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class Square implements Shape {
    private final String ln = System.lineSeparator();

    @Override
    public String draw() {
        StringBuilder picture = new StringBuilder();
        picture.append("******").append(ln);
        picture.append("*    *").append(ln);
        picture.append("*    *").append(ln);
        picture.append("*    *").append(ln);
        picture.append("*    *").append(ln);
        picture.append("******");
        return picture.toString();
    }
}
