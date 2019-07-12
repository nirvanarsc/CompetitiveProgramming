import java.util.HashSet;
import java.util.Set;

public final class UniqueMorseCodeWords {

    private static final String[] MORSE_CODE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
            "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    private static int uniqueMorseRepresentations(String[] words) {
        final Set<String> res = new HashSet<>();

        for (String s : words) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(MORSE_CODE[s.charAt(i) - 97]);
            }
            res.add(sb.toString());
        }

        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
