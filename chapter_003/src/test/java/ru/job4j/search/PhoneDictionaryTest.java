package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        Person prs1 = new Person("Harry", "Potter", "289567", "Hogwarts");
        Person prs2 = new Person("Henry", "ford", "567289", "Ireland");
        Person prs3 = new Person("Petr", "Arsentev", "534872", "Bryansk");
        phones.add(prs1);
        phones.add(prs2);
        phones.add(prs3);
        List<Person> persons = phones.find("289");
        List<Person> expect  = new ArrayList<>();
        expect.add(prs1);
        expect.add(prs2);
        assertThat(persons, hasSize(2));
        assertThat(persons.toArray(), arrayContainingInAnyOrder(expect.toArray()));
    }
}
