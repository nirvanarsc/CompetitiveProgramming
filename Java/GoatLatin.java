import java.util.HashSet;
import java.util.Set;

public final class GoatLatin {

    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public static String toGoatLatin(String s) {
        final StringBuilder res = new StringBuilder();
        int i = 1;
        for (String w : s.split(" ")) {
            res.append(' ')
               .append(VOWELS.contains(Character.toLowerCase(w.charAt(0))) ? w : w.substring(1) + w.charAt(0))
               .append("ma");
            for (int j = i; j > 0; j--) {
                res.append('a');
            }
            i++;
        }
        return res.substring(1);
    }

    private GoatLatin() {}
}
