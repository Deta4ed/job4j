package ru.job4j.lambda;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

class MatchUtilTest {

    @Test
    public void whenAdd1UntilThreeThenlineFunction() {
        List<Double> buffer = new MatchUtil().diapason(1, 3, (x) -> x);
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }

    @Test
    public void whenAdd1UntilThreeThenSquareFunction() {
        List<Double> buffer = new MatchUtil().diapason(1, 3, (x) -> x * x);
        assertThat(buffer, is(Arrays.asList(1D, 4D, 9D)));
    }

    @Test
    public void whenAdd1UntilThreeThenLogFunction() {
        List<Double> buffer = new MatchUtil().diapason(1, 3, (x) -> Math.log(x));
        assertThat(buffer, is(Arrays.asList(0.0, 0.6931471805599453, 1.0986122886681098)));
    }
}
