package calculator;

public class StringCalculator {

	 int add(String numbers) {
		 
		//If string is empty 
		if (numbers.isEmpty()) {
	        return 0;
	    }
		
		//Splitting string at commas and new lines
	    String[] numberArray = numbers.split(",|\n");
	    int sum = 0;
	    
	    for (String number : numberArray) {
	        try {
	        	//Parsing and adding
	            sum += Integer.parseInt(number);
	        } catch (NumberFormatException e) {
	            System.out.println("Failed to parse number: " + number);
	        }
	    }
	    
	    
	    return sum;
	}
}
