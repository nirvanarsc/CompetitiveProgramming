package leetcode.weekly_contests.weekly_300_399.weekly_314;

public class P_1 {

    public int hardestWorker(int n, int[][] logs) {
        int longest = -1;
        int res = -1;
        int prev = 0;
        for (int[] log : logs) {
            final int t = log[1] - prev;
            if (t > longest) {
                longest = t;
                res = log[0];
            } else if (t == longest) {
                res = Math.min(res, log[0]);
            }
            prev = log[1];
        }
        return res;
    }
}
