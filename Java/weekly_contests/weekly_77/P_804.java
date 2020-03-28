package weekly_contests.weekly_77;

import java.util.HashSet;
import java.util.Set;

public class P_804 {

    private static final String[] MORSE_CODE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        final Set<String> set = new HashSet<>();
        for (String w : words) {
            final StringBuilder sb = new StringBuilder();
            for (char c : w.toCharArray()) {
                sb.append(MORSE_CODE[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
