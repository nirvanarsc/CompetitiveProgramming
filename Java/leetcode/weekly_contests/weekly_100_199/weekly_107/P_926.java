package leetcode.weekly_contests.weekly_100_199.weekly_107;

public class P_926 {

    public int minFlipsMonoIncr(String s) {
        final int n = s.length();
        final int[] z = new int[n + 1];
        final int[] o = new int[n + 1];
        final char[] w = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            final int[] add = new int[2];
            add[w[i - 1] - '0']++;
            z[i] = z[i - 1] + add[0];
            o[i] = o[i - 1] + add[1];
        }
        int res = (int) 1e9;
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, o[i] + z[n] - z[i]);
        }
        return res;
    }
}
