import java.util.Arrays;

class Acronym {

    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        String[] words = this.phrase.split("[ -]");
        return Arrays.stream(words)
                .map(s -> s.substring(0, 1))
                .map(s -> s.toUpperCase())
                .reduce("", String::concat);
    }

}
