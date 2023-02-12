package leetcode.weekly_contests.weekly_300_399.weekly_332;

public class P_4 {

    public int minimumScore(String s, String t) {
        final char[] l = s.toCharArray();
        final char[] r = t.toCharArray();
        final int n = l.length;
        final int m = r.length;
        final int[] p = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < m && l[i] == r[j]) {
                j++;
            }
            p[i] = j;
        }
        int res = m - j;
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.min(res, Math.max(0, j - p[i] + 1));
            if (j >= 0 && l[i] == r[j]) {
                j--;
            }
        }
        return Math.min(res, j + 1);
    }
}
