package leetcode.weekly_contests.weekly_173;

public class P_1335 {

    private static final int INF = (int) 1e9;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        return recurse(0, d, jobDifficulty, new Integer[jobDifficulty.length][d + 1]);
    }

    private static int recurse(int start, int d, int[] jobs, Integer[][] dp) {
        if (d == 0 && start == jobs.length) {
            return 0;
        }
        if (d == 0 || start == jobs.length) {
            return INF;
        }
        if (dp[start][d] != null) {
            return dp[start][d];
        }

        int add = jobs[start];
        int res = INF;
        for (int j = start; j < jobs.length; j++) {
            add = Math.max(add, jobs[j]);
            final int startNew = recurse(j + 1, d - 1, jobs, dp);
            if (startNew != INF) {
                res = Math.min(res, startNew + add);
            }
        }
        return dp[start][d] = res;
    }
}
