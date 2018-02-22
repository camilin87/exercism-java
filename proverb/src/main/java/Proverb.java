import java.util.stream.IntStream;

class Proverb {

    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        return IntStream.range(0, words.length - 1)
            .mapToObj(this::getLine)
            .reduce("", Proverb::concatLines)
            .concat(getEnding());
    }

    private static String concatLines(String a, String b){
        return String.format("%s%s\n", a, b);
    }

    private String getLine(int i) {
        return String.format("For want of a %s the %s was lost.", words[i], words[i + 1]);
    }

    private String getEnding(){
        if (words.length == 0) {
            return "";
        }

        return String.format("And all for the want of a %s.", words[0]);
    }

}
