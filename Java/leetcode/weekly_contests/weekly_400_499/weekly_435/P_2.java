package leetcode.weekly_contests.weekly_400_499.weekly_435;

public class P_2 {

    public int maxDistance(String s, int k) {
        final int[] f = new int[4];
        final char[] w = s.toCharArray();
        final int n = s.length();
        final String dirs = "NSEW";
        int res = 0;
        for (int i = 0; i < n; i++) {
            f[dirs.indexOf(w[i])]++;
            final int u = Math.max(f[0], f[1]) + Math.max(f[2], f[3]);
            final int v = Math.min(f[0], f[1]) + Math.min(f[2], f[3]);
            final int save = Math.min(v, k);
            res = Math.max(res, u - v + 2 * save);
        }
        return res;
    }
}
