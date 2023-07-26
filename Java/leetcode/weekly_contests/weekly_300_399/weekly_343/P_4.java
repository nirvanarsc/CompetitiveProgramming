package leetcode.weekly_contests.weekly_300_399.weekly_343;

public class P_4 {

    public String smallestBeautifulString(String s, int k) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            for (int ch = w[i] + 1; ch < 'a' + k; ch++) {
                if (isValid(w, i, ch)) {
                    w[i] = (char) ch;
                    for (int j = i + 1; j < n; j++) {
                        for (char cand = 'a'; cand < 'a' + k; cand++) {
                            if (isValid(w, j, cand)) {
                                w[j] = cand;
                                break;
                            }
                        }
                    }
                    return new String(w);
                }
            }
        }
        return "";
    }

    private static boolean isValid(char[] w, int i, int ch) {
        return (i < 1 || w[i - 1] != ch) && (i < 2 || w[i - 2] != ch);
    }
}
