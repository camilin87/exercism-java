import java.util.Arrays;
import java.util.stream.IntStream;

class LuhnValidator {

    boolean isValid(String candidate) {
        int[] digits = new StringBuilder(candidate)
                .reverse()
                .toString()
                .replace(" ", "")
                .chars()
                .map(Character::getNumericValue)
                .toArray();

        if (digits.length < 2){
            return false;
        }

        if (Arrays.stream(digits).anyMatch(LuhnValidator::isInvalid)){
            return false;
        }

        int sum = IntStream.range(0, digits.length)
                .map(i -> calculateDigitValue(digits[i], i))
                .sum();

        return sum % 10 == 0;
    }

    private static boolean isInvalid(Integer digit){
        return digit < 0 || digit > 9;
    }

    private static Integer calculateDigitValue(Integer digit, Integer index){
        if (index % 2 == 0){
            return digit;
        }

        int digitDoubled = digit << 1;

        if (digitDoubled >= 10){
            return digitDoubled - 9;
        }

        return digitDoubled;
    }

}
