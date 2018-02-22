import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Sieve {
    private final int maxPrime;

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    List<Integer> getPrimes() {
        boolean[] numbers = new boolean[maxPrime + 1];

        numbers[0] = false;
        numbers[1] = false;

        for (int i = 2; i < maxPrime + 1; i++) {
            numbers[i] = true;
        }

        int upperBound = ((int)Math.sqrt(maxPrime)) + 1;

        for (int i = 2; i < upperBound; i++) {
            if (numbers[i]){
                for (int j = i + i; j < maxPrime + 1; j += i){
                    numbers[j] = false;
                }
            }
        }

        return IntStream.range(0, maxPrime + 1)
                .filter(i -> numbers[i])
                .boxed()
                .collect(Collectors.toList());
    }
}
