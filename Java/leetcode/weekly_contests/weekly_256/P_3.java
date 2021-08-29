package leetcode.weekly_contests.weekly_256;

public class P_3 {

    static int n;
    static int maxT;
    static boolean seen[][];
    static int dp[][];

    public int minSessions(int[] tasks, int sessionTime) {
        n = tasks.length;
        seen = new boolean[1 << n][maxT + 1];
        dp = new int[1 << n][maxT + 1];
        maxT = sessionTime;
        return dfs(tasks, (1 << n) - 1, maxT);
    }

    private static int dfs(int[] arr, int mask, int remT) {
        if (mask == 0) {
            return 0;
        }
        if (seen[mask][remT]) {
            return dp[mask][remT];
        }
        int res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                if (remT >= arr[i]) {
                    res = Math.min(res, dfs(arr, mask ^ (1 << i), remT - arr[i]));
                } else {
                    res = Math.min(res, 1 + dfs(arr, mask ^ (1 << i), maxT));
                }
            }
        }
        seen[mask][remT] = true;
        return dp[mask][remT] = res;
    }
}
