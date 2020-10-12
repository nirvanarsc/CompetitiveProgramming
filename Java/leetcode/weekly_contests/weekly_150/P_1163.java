package leetcode.weekly_contests.weekly_150;

public class P_1163 {

    // https://cp-algorithms.com/string/lyndon_factorization.html
    // https://en.wikipedia.org/wiki/Lexicographically_minimal_string_rotation
    public String lastSubstring(String s) {
        int i = 0;
        int j = 1;
        int offset = 0;
        final int len = s.length();
        while (i + offset < len && j + offset < len) {
            final char c = s.charAt(i + offset);
            final char d = s.charAt(j + offset);
            if (c == d) {
                ++offset;
            } else {
                if (c < d) { i += offset + 1; } else { j += offset + 1; }
                if (i == j) { ++i; }
                offset = 0;
            }
        }
        return s.substring(Math.min(i, j));
    }
}
