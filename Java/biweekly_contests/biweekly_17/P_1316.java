package biweekly_contests.biweekly_17;

import java.util.HashSet;
import java.util.Set;

public class P_1316 {

    public int distinctEchoSubstrings(String text) {
        final Set<String> found = new HashSet<>();
        final char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (chars[i] == chars[j]) {
                    if (j + j - i <= text.length()) {
                        final String first = text.substring(i, j);
                        final String second = text.substring(j, j + j - i);
                        if (first.equals(second)) {
                            found.add(first + second);
                        }
                    }
                }
            }
        }

        return found.size();
    }
}
