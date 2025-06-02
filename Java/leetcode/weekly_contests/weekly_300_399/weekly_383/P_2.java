package leetcode.weekly_contests.weekly_300_399.weekly_383;

public class P_2 {

    public int minimumTimeToInitialState(String word, int k) {
        final int n = word.length();
        final int[] lps = buildLPS(word);
        int res = lps[n - 1];
        while (res > 0 && (n - res) % k > 0) {
            res = lps[res - 1];
        }
        return (n - res + k - 1) / k;
    }

    private static int[] buildLPS(String s) {
        final int n = s.length();
        final int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }
}
