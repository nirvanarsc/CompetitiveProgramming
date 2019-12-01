import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Hexspeak {

    public static void main(String[] args) {
        System.out.println(toHexspeak("619879596177"));
        System.out.println(toHexspeak("3"));
        System.out.println(toHexspeak("15"));
    }

    public static String toHexspeak(String num) {
        final char[] chars = Long.toHexString(Long.parseLong(num)).toUpperCase().toCharArray();
        final Set<Character> valid = new HashSet<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O'));

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                chars[i] = 'O';
            }
            if (chars[i] == '1') {
                chars[i] = 'I';
            }
            if (!valid.contains(chars[i])) {
                return "ERROR";
            }
        }

        return new String(chars);
    }

    private Hexspeak() {}
}
