package leetcode.weekly_contests.weekly_100_199.weekly_107;

public class P_926 {

    public int minFlipsMonoIncr(String s) {
        final int n = s.length();
        final int[] z = new int[n + 1];
        final int[] o = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            final boolean one = s.charAt(i - 1) == '1';
            z[i] = z[i - 1] + (!one ? 1 : 0);
            o[i] = o[i - 1] + (one ? 1 : 0);
        }
        int res = (int) 1e9;
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, o[i] + z[n] - z[i]);
        }
        return res;
    }
}
