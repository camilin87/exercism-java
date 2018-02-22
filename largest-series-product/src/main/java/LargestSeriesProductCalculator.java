import java.util.Arrays;
import java.util.stream.IntStream;

class LargestSeriesProductCalculator {
    private final String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        if (inputNumber.chars().anyMatch(c -> !Character.isDigit(c))){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }

        this.inputNumber = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        validateInput(numberOfDigits);

        long[] digits = inputNumber.chars()
                .mapToLong(Character::getNumericValue)
                .toArray();

        return IntStream.rangeClosed(0, digits.length - numberOfDigits)
                .mapToLong(startIndex -> product(digits, startIndex, numberOfDigits))
                .max()
                .getAsLong();
    }

    private static long product(long[] digits, int startIndex, int length){
        return Arrays.stream(digits)
                .skip(startIndex)
                .limit(length)
                .reduce(1, (x, y) -> x * y);
    }

    private void validateInput(int numberOfDigits) {
        if (numberOfDigits < 0){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }

        if (numberOfDigits > inputNumber.length()){
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
    }
}
