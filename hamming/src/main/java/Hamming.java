import java.util.stream.IntStream;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;

    Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;

        if (this.leftStrand.length() != this.rightStrand.length()){
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    int getHammingDistance() {
        return IntStream.range(0, this.leftStrand.length())
                .map(i -> getStrandDifferencesAt(i))
                .sum();
    }

    private int getStrandDifferencesAt(int i){
        if (this.leftStrand.charAt(i) == this.rightStrand.charAt(i)) {
            return 0;
        }

        return 1;
    }
}
