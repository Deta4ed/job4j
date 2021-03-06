package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PhoneDictionary.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Add person.
     * @param person - person.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Return the list of all users who hold the key in any fields.
     * @param key - The search key.
     * @return - List of eligible users.
     */
    public List<Person> find(String key) {
        return persons.stream().filter(person -> person.getAddress().contains(key)
                || person.getName().contains(key)
                || person.getPhone().contains(key)
                || person.getSurname().contains(key)).collect(Collectors.toList());

    }
}
