package ru.job4j.models;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ModelsTest {
    @Test
    public void whenPatientIsIllThenPatientIsHelthy() {
        Patient patient = new Patient("Mike");
        Doctor doc = new Doctor("Henry", "Therapist");
        String result = doc.heal(patient);
        String expect = new String("Therapist Henry cured Mike");
        assertThat(result, is(expect));
    }
}
