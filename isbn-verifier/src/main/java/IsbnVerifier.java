import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        if (stringToVerify == null || stringToVerify == ""){
            return false;
        }

        int separatorIndex = stringToVerify.lastIndexOf('X');
        if (separatorIndex > 0 && separatorIndex != stringToVerify.length() - 1){
            return false;
        }

        List<Integer> digits = stringToVerify
                .chars()
                .filter(IsbnVerifier::isValid)
                .mapToObj(IsbnVerifier::getValue)
                .collect(Collectors.toList());

        Collections.reverse(digits);

        int checksum = IntStream.range(0, digits.size())
                .map(i -> digits.get(i) * (i + 1))
                .sum();

        return checksum % 11 == 0;
    }

    private static Boolean isValid(Integer c){
        return Character.isDigit(c) || c == 'X';
    }

    private static Integer getValue(Integer c){
        if (c == 'X') {
            return 10;
        }

        return c - '0';
    }

}
