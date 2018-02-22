public class PangramChecker {
    private final int ALL_LETTERS_COUNT = 26;

    public boolean isPangram(String rawInput) {
        long uniqueCount = sanitize(rawInput)
                .toLowerCase()
                .chars()
                .filter(Character::isLetter)
                .distinct()
                .count();

        return uniqueCount == ALL_LETTERS_COUNT;
    }

    private String sanitize(String input){
       if (input == null){
           return "";
       }

       return input;
    }
}
