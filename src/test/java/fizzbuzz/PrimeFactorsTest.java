package fizzbuzz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeFactorsTest {

    @Test
    public void itShouldReturn2For2() throws Exception {
        PrimeFactor primeFactor = new PrimeFactor();
        assertThat(primeFactor.getMultiplicands(2), is(Arrays.asList(2)));
    }

    @Test
    public void itShouldReturn2_2For4() throws Exception {
        PrimeFactor primeFactor = new PrimeFactor();
        assertThat(primeFactor.getMultiplicands(4), is(Arrays.asList(2, 2)));
    }

    @Test
    public void itShouldReturn2_3For6() throws Exception {
        PrimeFactor primeFactor = new PrimeFactor();
        assertThat(primeFactor.getMultiplicands(6), is(Arrays.asList(2, 3)));
    }

    @Test
    public void itShouldReturn3_3For9() throws Exception {
        PrimeFactor primeFactor = new PrimeFactor();
        assertThat(primeFactor.getMultiplicands(9), is(Arrays.asList(3, 3)));
    }

    @Test
    public void itShouldReturn2_3_3_5_7_7For4410() throws Exception {
        PrimeFactor primeFactor = new PrimeFactor();
        assertThat(primeFactor.getMultiplicands(4410), is(Arrays.asList(2, 3, 3, 5, 7, 7)));
    }

    @Test
    public void itShouldReturn17For17() throws Exception {
        PrimeFactor primeFactor = new PrimeFactor();
        assertThat(primeFactor.getMultiplicands(17), is(Arrays.asList(17)));
    }

    private class PrimeFactor {
        public List<Integer> getMultiplicands(int n) {
            List<Integer> result = new ArrayList<Integer>();
            int remainder = n;

            for (int i = 2; i <= Math.ceil(Math.sqrt(n)) && remainder != 1; i++) {
                if (remainder % i == 0) {
                    result.add(i);
                    remainder = remainder / i;
                    i--;
                }
            }

            if (n == remainder) {
                result.add(n);
            }

            return result;
        }
    }

}
