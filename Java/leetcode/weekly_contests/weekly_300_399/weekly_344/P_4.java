package leetcode.weekly_contests.weekly_300_399.weekly_344;

public class P_4 {

    static int res;

    public int minIncrements(int n, int[] cost) {
        res = 0;
        dfs(0, cost);
        return res;
    }

    private static int dfs(int u, int[] cost) {
        if (u >= cost.length) {
            return 0;
        }
        final int l = dfs(2 * u + 1, cost);
        final int r = dfs(2 * u + 2, cost);
        res += 2 * Math.max(l, r) - (l + r);
        return cost[u] + Math.max(l, r);
    }
}
