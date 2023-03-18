package leetcode.biweekly_contests.biweekly_0_99.biweekly_88;

public class P_1 {

    public boolean equalFrequency(String word) {
        final int n = word.length();
        final char[] w = word.toCharArray();
        for (int i = 0; i < n; i++) {
            if (f(w, i, n)) {
                return true;
            }
        }
        return false;
    }

    private static boolean f(char[] w, int idx, int n) {
        final int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            if (i == idx) {
                continue;
            }
            f[w[i] - 'a']++;
        }
        int t = -1;
        for (int i = 0; i < 26; i++) {
            if (f[i] > 0) {
                if (t == -1) {
                    t = f[i];
                } else if (f[i] != t) {
                    return false;
                }
            }
        }
        return true;
    }
}
