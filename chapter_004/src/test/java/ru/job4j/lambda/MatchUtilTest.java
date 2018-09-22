package ru.job4j.lambda;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

class MatchUtilTest {

    @Test
    public void whenAdd1Until3lineFunction() {
        List<Double> buffer = new MatchUtil().diapason(1, 3, new Function<Double, Double>() {
            @Override
            public Double apply(Double aDouble) {
                return aDouble * 2 + 2;
            }
        });
        assertThat(buffer, is(Arrays.asList(4D, 6D, 8D)));
    }






}