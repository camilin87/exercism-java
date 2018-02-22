import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ProteinTranslator {
    private final HashMap<String, String> codonProteinMappings = new HashMap<String, String>() {{
        put("AUG", "Methionine");

        put("UUU", "Phenylalanine");
        put("UUC", "Phenylalanine");

        put("UUA", "Leucine");
        put("UUG", "Leucine");

        put("UCU", "Serine");
        put("UCC", "Serine");
        put("UCA", "Serine");
        put("UCG", "Serine");

        put("UAU", "Tyrosine");
        put("UAC", "Tyrosine");

        put("UGU", "Cysteine");
        put("UGC", "Cysteine");

        put("UGG", "Tryptophan");
    }};

    private final String[] stopCodons = new String[] { "UAA", "UAG", "UGA" };

    List<String> translate(String rnaSequence) {
        String stopCodonsRegex = String.join("|", stopCodons);
        String[] sequences = rnaSequence.split(stopCodonsRegex);
        String validRnaSequence = sequences.length == 0 ? "" : sequences[0];

        return IntStream.range(2, validRnaSequence.length())
                .filter(i -> (i + 1) % 3 == 0)
                .mapToObj(i -> validRnaSequence.substring(i - 2, i + 1))
                .map(c -> codonProteinMappings.get(c))
                .collect(Collectors.toList());
    }
}