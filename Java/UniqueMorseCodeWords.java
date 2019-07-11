import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    private static String[] morseCode = new String[]
            {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
                    ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    private static int uniqueMorseRepresentations(String[] words) {
        Set<String> res = new HashSet<>();

        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(morseCode[s.charAt(i) - 97]);
            }
            res.add(sb.toString());
        }

        return res.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
