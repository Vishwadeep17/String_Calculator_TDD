package calculator;

public class StringCalculator {

	 int add(String numbers) {
		if (numbers.isEmpty()) {
	        return 0;
	    }
	    String[] numberArray = numbers.split(",");
	    int sum = 0;
	    for (String number : numberArray) {
	        try {
	            sum += Integer.parseInt(number);
	        } catch (NumberFormatException e) {
	            System.out.println("Failed to parse number: " + number);
	        }
	    }
	    return sum;
	}
}
