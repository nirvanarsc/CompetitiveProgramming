package leetcode.weekly_contests.weekly_300_399.weekly_390;

public class P_1 {

    public int maximumLengthSubstring(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final int[] f = new int[26];
        int j = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            f[w[i] - 'a']++;
            while (f[w[i] - 'a'] > 2) {
                f[w[j++] - 'a']--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
