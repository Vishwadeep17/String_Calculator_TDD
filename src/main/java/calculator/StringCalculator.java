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
                int currValue = Integer.parseInt(number);

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
            Matcher matcher = Pattern.compile("//\\[(.+?)\\]\n(.*)").matcher(numbers);
            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1)); // Use the custom delimiter
                numbers = matcher.group(2); // Update the numbers string to exclude the custom delimiter part
            } else {
                matcher = Pattern.compile("//(.)\n(.*)").matcher(numbers);
                if (matcher.matches()) {
                    delimiter = Pattern.quote(matcher.group(1)); // Use the custom single-character delimiter
                    numbers = matcher.group(2); // Update the numbers string to exclude the custom delimiter part
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
                int num = Integer.parseInt(number);
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
