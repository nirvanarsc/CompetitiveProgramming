import java.util.ArrayList;
import java.util.List;

public final class OccurrencesAfterBigram {

    public static final String[] STRINGS = new String[0];

    public static void main(String[] args) {
        final String text = "we will we will rock you";
        final String first = "we";
        final String second = "will";

        for (String s : findOccurrences(text, first, second)) {
            System.out.println(s);
        }
        for (String s : findOccurrences2(text, first, second)) {
            System.out.println(s);
        }
    }

    public static String[] findOccurrences(String text, String first, String second) {
        final String combined = String.join(" ", first, second);
        final List<String> res = new ArrayList<>();
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < text.length() - combined.length(); i++) {
            if (matches(text, combined, i)) {
                for (int j = i + combined.length() + 1; j < text.length(); j++) {
                    if (text.charAt(j) == 32) {
                        res.add(builder.toString());
                        builder.setLength(0);
                        break;
                    }
                    builder.append(text.charAt(j));
                    if (j == text.length() - 1) {
                        res.add(builder.toString());
                        break;
                    }
                }
                i += combined.length();
            }
        }

        return res.toArray(STRINGS);
    }

    private OccurrencesAfterBigram() {}

    private static boolean matches(String text, String combined, int i) {
        return text.substring(i, i + combined.length()).equals(combined);
    }

    public static String[] findOccurrences2(String text, String first, String second) {
        final String[] words = text.split(" ");
        final List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1])) {
                ans.add(words[i]);
            }
        }
        return ans.toArray(STRINGS);
    }
}
