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
    void string_with_AnyNumbers() {
    	int value = sc1.add("1,5,34,56,98");
    	Assertions.assertEquals(value, 194);
    	
    	value = sc1.add("100,105,200,400,321,93");
    	Assertions.assertEquals(value, 1219);
    }
    
    // 5. String with \n for addition
    @Test
    void string_with_newLine() {
        int value = sc1.add("1,2\n3");
        Assertions.assertEquals(6, value);
        
        value = sc1.add("1,34\n23,89\n3\n4");
        Assertions.assertEquals(value, 154);
    }
    
    // 6. Strings with custom delimiters, add method should separate numbers by that delimiter
    @Test
    void string_with_custom_delimiter() {
    	int value = sc1.add("//;\n1;2");
    	Assertions.assertEquals(value, 3);
    	
    	value = sc1.add("//*\n1*23*45*58");
    	Assertions.assertEquals(value,127);
    }
    
    // 7. Strings with negative number should throw exception
    @Test
    void string_with_negative_numbers() {
        IllegalArgumentException thrown = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> sc1.add("1,-2,3,-4")
        );
        Assertions.assertEquals("Negative numbers not allowed: -2, -4", thrown.getMessage());
    }

    // 8. Strings with custom delimiter having negative values
    @Test
    void string_with_custom_delimiter_and_negative_numbers() {
        IllegalArgumentException thrown = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> sc1.add("//;\n1;-2;3;-4;-5")
        );
        Assertions.assertEquals("Negative numbers not allowed: -2, -4, -5", thrown.getMessage());
    }
    
    // 9. If string has some numbers with value greater than 1000, then ignore it.
    @Test
    void string_with_greaterThan1000() {
    	int value = sc1.add("100,20,56\n1001,700\n3020,12"); 
    	Assertions.assertEquals(value, 888);
    	
    	//With delimiter
    	value = sc1.add("//$\n12$23$1001$15$1003");
    	Assertions.assertEquals(value, 50);
    }
    
    // 10. String with custom delimiter of any length
    @Test
    void string_with_custom_delimiter_anyLength() {
    	int value = sc1.add("//[***]\n1***2***3"); 
    	Assertions.assertEquals(value, 6);
    }
}
