package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // Default delimiters: comma and newline
    private String delimiter = ",|\n";

    public int add(String numbers) {
        // If the string is empty
        if (numbers.isEmpty()) {
            return 0;
        }

        // Check and set custom delimiter if present
        numbers = setCustomDelimiter(numbers);

        // Split the string using the determined delimiter(s)
        String[] numberArray = numbers.split(delimiter);

        // Check for negative numbers and throw an exception if any are found
        checkForNegativeNumbers(numberArray);

        int sum = 0;

        for (String number : numberArray) {
            try {
                int currValue = Integer.parseInt(number.trim());

                // If number is greater than 1000, then ignore it.
                if (currValue > 1000) continue;
                sum += currValue;
            } catch (NumberFormatException e) {
                System.out.println("Failed to parse number: " + number);
            }
        }

        // Reset delimiter to default after processing
        delimiter = ",|\n";

        return sum;
    }

    // Method to check and set custom delimiter if present
    private String setCustomDelimiter(String numbers) {
        if (numbers.startsWith("//")) {
            // Matcher to capture multiple delimiters of varying lengths
            Matcher matcher = Pattern.compile("//(\\[.*?\\])\n(.*)").matcher(numbers);
            if (matcher.find()) {
                String delimiterPart = matcher.group(1);
                
                // Updating new numbers string with removing front delimiters
                numbers = matcher.group(2);

                // Removing outer [ and ],  and splitting by ][
                delimiterPart = delimiterPart.substring(1, delimiterPart.length() - 1);
                String[] delimiters = delimiterPart.split("\\]\\[");

                // Appending all delimiters
                StringBuilder delimiterPattern = new StringBuilder();
                for (String delim : delimiters) {
                    if (delimiterPattern.length() > 0) {
                        delimiterPattern.append("|");
                    }
                    delimiterPattern.append(Pattern.quote(delim));
                }
                delimiter = delimiterPattern.toString();

            } else {
                matcher = Pattern.compile("//(.*?)\n(.*)").matcher(numbers);
                if (matcher.find()) {
                    delimiter = Pattern.quote(matcher.group(1)); // Use the custom delimiter
                    
                    // Updating new numbers string with removing front delimiters
                    numbers = matcher.group(2);
                }
            }
        }
        return numbers;
    }


    // Method to check for negative numbers and throw an exception if any are found
    private void checkForNegativeNumbers(String[] numberArray) {
        List<String> negativeNumbers = new ArrayList<>();
        for (String number : numberArray) {
            try {
                int num = Integer.parseInt(number.trim());
                if (num < 0) {
                    negativeNumbers.add(number);
                }
            } catch (NumberFormatException e) {
                System.out.println("Failed to parse number: " + number);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(", ", negativeNumbers));
        }
    }
}
