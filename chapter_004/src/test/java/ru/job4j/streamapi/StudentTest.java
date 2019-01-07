package ru.job4j.streamapi;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

class StudentTest {

    @Test
    public void when() {
        Student st1 = new Student("Petrov", 5);
        Student st2 = new Student("Ivanov", 10);
        List<Student> result = Student.levelOf(new ArrayList<Student>(Arrays.asList(st1, null, st2)), 7);
        assertThat(List.of(st2), is(result));
    }
}