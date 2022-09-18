package leetcode.weekly_contests.weekly_300_399.weekly_311;

public class P_2 {

    public int longestContinuousSubstring(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && w[j] - w[j - 1] == 1) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j - 1;
        }
        return res;
    }
}
