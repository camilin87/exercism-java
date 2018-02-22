import java.util.Arrays;

class Triangle {
    private final long differentSides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        double[] sides = new double[]{ side1, side2, side3 };

        if (Arrays.stream(sides).anyMatch(i -> i <= 0)){
            throw new TriangleException();
        }

        double sidesSum = Arrays.stream(sides).sum();

        if (Arrays.stream(sides).anyMatch(i -> (sidesSum - i) < i)){
            throw new TriangleException();
        }

        differentSides = Arrays.stream(sides).distinct().count();
    }

    boolean isEquilateral() {
        return differentSides == 1;
    }

    boolean isIsosceles() {
        return differentSides <= 2;
    }

    boolean isScalene() {
        return differentSides == 3;
    }

}
