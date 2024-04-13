package leetcode.biweekly_contests.biweekly_100_199.biweekly_128;

public class P_1 {

    public int scoreOfString(String s) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += Math.abs(w[i + 1] - w[i]);
        }
        return res;
    }
}
