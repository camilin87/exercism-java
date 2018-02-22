import java.util.HashMap;

class RnaTranscription {

    private static final HashMap<Character, Character> translator = new HashMap<Character, Character>(){{
        put('C', 'G');
        put('G', 'C');
        put('T', 'A');
        put('A', 'U');
    }};

    public String transcribe(String dnaStrand) {
        return dnaStrand
                .chars()
                .mapToObj(c -> (char)c)
                .map(c -> translator.get(c))
                .map(c -> c.toString())
                .reduce(String::concat)
                .get();
    }
}
