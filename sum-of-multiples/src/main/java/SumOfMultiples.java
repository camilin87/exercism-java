import java.util.Arrays;
import java.util.stream.IntStream;

class SumOfMultiples {

    private final int number;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        return IntStream.range(1, number)
                .filter(i -> Arrays.stream(set).anyMatch(j -> i % j == 0))
                .sum();
    }

}
