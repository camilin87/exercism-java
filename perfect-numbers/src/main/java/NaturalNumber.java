import java.util.stream.IntStream;

class NaturalNumber {
    private final int n;

    public NaturalNumber(int n){
        if (n < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

        this.n = n;
    }

    public Classification getClassification(){
        int sum = IntStream.rangeClosed(1, this.n / 2)
                .filter(i -> this.n % i == 0)
                .sum();

        if (sum > this.n){
            return Classification.ABUNDANT;
        }

        if (sum < this.n){
            return Classification.DEFICIENT;
        }

        return Classification.PERFECT;
    }
}
