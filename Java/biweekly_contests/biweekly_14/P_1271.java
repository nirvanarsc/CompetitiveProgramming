package biweekly_contests.biweekly_14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P_1271 {

    public String toHexspeak(String num) {
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
}
