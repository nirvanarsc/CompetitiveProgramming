package leetcode.weekly_contests.weekly_200_299.weekly_298;

public class P_3 {

    public int longestSubsequence(String s, int k) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        int t = 0;
        int c = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (w[i] == '0') {
                c++;
            } else if (c < 63 && t + (1L << c) <= k) {
                t += 1L << c;
                c++;
            }
        }
        return c;
    }
}
