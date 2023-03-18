package leetcode.biweekly_contests.biweekly_0_99.biweekly_74;

public class P_2 {

    public long maximumSubsequenceCount(String text, String pattern) {
        final int n = text.length();
        final int[] l = new int[n + 1];
        final int[] r = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            l[i] = l[i - 1] + (text.charAt(i - 1) == pattern.charAt(0) ? 1 : 0);
            r[i] = r[i - 1] + (text.charAt(i - 1) == pattern.charAt(1) ? 1 : 0);
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if (text.charAt(i - 1) == pattern.charAt(0)) {
                res += r[n] - r[i];
            }
        }
        return Math.max(res + l[n], res + r[n]);
    }
}
