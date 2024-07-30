package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {

    StringCalculator sc1 = new StringCalculator();

    // 1. For empty string, add method should return 0
    @Test
    void empty_String() {
        int value = sc1.add("");
        Assertions.assertEquals(value, 0);
    }

    // 2. For single number string, add should return same number.
    @Test
    void string_with_Onenumber() {
        int value = sc1.add("1");
        Assertions.assertEquals(value, 1);
        value = sc1.add("90");
        Assertions.assertEquals(value, 90);
    }

    // 3. For two numbers string separated by comma, add method should return sum of both.
    @Test
    void string_with_Twonumbers() {
        int value = sc1.add("1,5");
        Assertions.assertEquals(value, 6);
        value = sc1.add("23,35");
        Assertions.assertEquals(value, 58);
    }
    
    // 4. For handling strings with any amount of numbers.
    @Test
    void string_with_Anynumbers() {
    	int value = sc1.add("1,5,34,56,98");
    	Assertions.assertEquals(value, 194);
    	value = sc1.add("100,1000,200,400,321,93");
    	Assertions.assertEquals(value, 2114);
    }
    
    // 5. String with \n for addition
    @Test
    void string_with_newLine() {
    	int value = sc1.add("1\n2,3");
    	Assertions.assertEquals(value, 6);
    }
}
