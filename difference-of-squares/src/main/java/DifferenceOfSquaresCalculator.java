import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int n) {
        int sum = IntStream.rangeClosed(1, n).sum();
        return (int)Math.pow(sum, 2);
    }

    int computeSumOfSquaresTo(int n) {
        return IntStream.rangeClosed(1, n)
                .map(i -> (int)Math.pow(i, 2))
                .sum();
    }

    int computeDifferenceOfSquares(int n) {
        return computeSquareOfSumTo(n) - computeSumOfSquaresTo(n);
    }

}
