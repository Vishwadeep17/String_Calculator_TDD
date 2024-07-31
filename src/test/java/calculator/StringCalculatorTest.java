package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {

    StringCalculator sc1 = new StringCalculator();

    // 1. For empty string, add method should return 0
    @Test
    void empty_String() {
        int value = sc1.add("");
        Assertions.assertEquals(0,value);
    }

    // 2. For single number string, add should return same number.
    @Test
    void string_with_Onenumber() {
        int value = sc1.add("1");
        Assertions.assertEquals(1,value);
        
        value = sc1.add("90");
        Assertions.assertEquals(90,value);
    }

    // 3. For two numbers string separated by comma, add method should return sum of both.
    @Test
    void string_with_Twonumbers() {
        int value = sc1.add("1,5");
        Assertions.assertEquals(6,value);
        
        value = sc1.add("23,35");
        Assertions.assertEquals(58,value);
    }
    
    // 4. For handling strings with any amount of numbers.
    @Test
    void string_with_AnyNumbers() {
    	int value = sc1.add("1,5,34,56,98");
    	Assertions.assertEquals(194,value);
    	
    	value = sc1.add("100,105,200,400,321,93");
    	Assertions.assertEquals(1219, value);
    }
    
    // 5. String with \n for addition
    @Test
    void string_with_newLine() {
        int value = sc1.add("1,2\n3");
        Assertions.assertEquals(6, value);
        
        value = sc1.add("1,34\n23,89\n3\n4");
        Assertions.assertEquals(154,value);
    }
    
    // 6. Strings with custom delimiters, add method should separate numbers by that delimiter
    @Test
    void string_with_custom_delimiter() {
    	int value = sc1.add("//;\n1;2");
    	Assertions.assertEquals(3,value);
    	
    	value = sc1.add("//*\n1*23*45*58");
    	Assertions.assertEquals(127,value);
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
    	int value = sc1.add("100,20,56\n1001\n3020,12"); 
    	Assertions.assertEquals(188,value);
    	
    	//With delimiter
    	value = sc1.add("//$\n12$23$1001$15$1003");
    	Assertions.assertEquals(50,value);
    }
    
    // 10. String with custom delimiter of any length
    @Test
    void string_with_custom_delimiter_anyLength() {
    	int value = sc1.add("//[***]\n1***2***3"); 
    	Assertions.assertEquals(6,value);
    	
    	value = sc1.add("//[!!!!]\n2!!!!32!!!!6");
    	Assertions.assertEquals(40,value);
    }
    
    // 11. String with multiple custom delimiters (of length 1)
    @Test
    void string_with_multiple_custom_delimiter() {
    	int value = sc1.add("//[*][#]\n1*22*34#20#10");
    	Assertions.assertEquals(87,value);
    	
    	value = sc1.add("//[$][@]\n5$67$3@25@50");
    	Assertions.assertEquals(150,value);
    }
    
    // 12. String with multiple custom delimiters of any length
    @Test
    void string_with_multiple_custom_delimiters_anyLength() {
    	int value = sc1.add("//[***][@@]\n1***2***4@@3@@50");
    	Assertions.assertEquals(60,value);
    	
    	value = sc1.add("//[###][@@]\n2###5###40@@3@@50");
    	Assertions.assertEquals(value, 100);
    	
    	value = sc1.add("//[///][@@]\n2///3///4@@5");
    	Assertions.assertEquals(14,value);
    }
    
    // 13. String with numbers between 500 and 1000 should be subtracted 
    @Test
    void string_with_numbers_between_500_and_1000() {
    	int value = sc1.add("1,2\n505,400,700\n450");
    	//1+2-505+400-700+450 = -352
    	Assertions.assertEquals(-352, value);
    }
}
