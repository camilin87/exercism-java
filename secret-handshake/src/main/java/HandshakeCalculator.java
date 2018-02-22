import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class HandshakeCalculator {

    private final HashMap<Integer, Signal> conversions = new HashMap<Integer, Signal>() {{
        put(1, Signal.WINK);
        put(2, Signal.DOUBLE_BLINK);
        put(4, Signal.CLOSE_YOUR_EYES);
        put(8, Signal.JUMP);
    }};

    List<Signal> calculateHandshake(int number) {
        List<Signal> result = conversions
                .keySet()
                .stream()
                .filter(i -> (number & i) == i)
                .map(i -> conversions.get(i))
                .collect(Collectors.toList());

        if ((number & 16) == 16) {
            Collections.reverse(result);
        }

        return result;
    }
}
