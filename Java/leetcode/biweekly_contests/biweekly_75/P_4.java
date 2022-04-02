package leetcode.biweekly_contests.biweekly_75;

public class P_4 {

    // https://cp-algorithms.com/string/z-function.html
    private static int[] zFunction(char[] w) {
        final int n = w.length;
        final int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && w[z[i]] == w[i + z[i]]) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }

    public long sumScores(String s) {
        long res = 0;
        final int[] z = zFunction(s.toCharArray());
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            res += z[i];
        }
        return res + n;
    }
}
