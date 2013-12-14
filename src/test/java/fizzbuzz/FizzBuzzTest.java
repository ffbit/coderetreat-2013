package fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzTest {

    private FizzBuzz fizzbuzz;

    @Before
    public void setUp() throws Exception {
        fizzbuzz = new FizzBuzz();
    }

    @Test
    public void itShouldReturn1For1() throws Exception {
        assertThat(fizzbuzz.getHint(1), is("1"));
    }

    @Test
    public void itShouldReturnFizzFor3() throws Exception {
        assertThat(fizzbuzz.getHint(3), is("fizz"));
    }

    @Test
    public void itShouldReturnBuzzFor5() throws Exception {
        assertThat(fizzbuzz.getHint(5), is("buzz"));
    }

    @Test
    public void itShouldReturnFizzbuzzFor15() throws Exception {
        assertThat(fizzbuzz.getHint(15), is("fizzbuzz"));
    }

    private class FizzBuzz {

        public String getHint(int n) {
            if (n % 15 == 0) {
                return "fizzbuzz";
            } else if (n % 3 == 0) {
                return "fizz";
            } else if (n % 5 == 0) {
                return "buzz";
            }

            return String.valueOf(n);
        }

    }
}
