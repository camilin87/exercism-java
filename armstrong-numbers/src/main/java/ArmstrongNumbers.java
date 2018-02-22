class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String digits = Integer.toString(numberToCheck);

        double sum = digits
                .chars()
                .mapToLong(Character::getNumericValue)
                .mapToDouble(d -> Math.pow(d, digits.length()))
                .sum();

        return numberToCheck == (int)sum;
    }

}
