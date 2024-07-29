package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {

    StringCalculator sc1 = new StringCalculator();

    // 1. For empty string, add method should return 0
    @Test
    void emptyString() {
        int value = sc1.add("");
        Assertions.assertEquals(value, 0);
    }

    // 2. For single number string, add should return same number.
    @Test
    void stringwithOnenumber() {
        int value = sc1.add("1");
        Assertions.assertEquals(value, 1);
        value = sc1.add("90");
        Assertions.assertEquals(value, 90);
    }

    // 3. For two numbers string separated by comma, add method should return sum of both.
    @Test
    void stringwithTwonumber() {
        int value = sc1.add("1,5");
        Assertions.assertEquals(value, 6);
        value = sc1.add("23,35");
        Assertions.assertEquals(value, 58);
    }
}
