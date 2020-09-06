package biweekly_contests.biweekly_34;

public class P_1575 {

    private static final int MOD = (int) (1e9 + 7);

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        return dfs(locations, start, finish, fuel, new Integer[locations.length][fuel + 1]);
    }

    private static int dfs(int[] locations, int start, int finish, int fuel, Integer[][] dp) {
        if (dp[start][fuel] != null) {
            return dp[start][fuel];
        }
        int res = start == finish ? 1 : 0;
        for (int i = 0; i < locations.length; i++) {
            final int cost = Math.abs(locations[start] - locations[i]);
            if (i != start && cost <= fuel) {
                res = (res + dfs(locations, i, finish, fuel - cost, dp)) % MOD;
            }
        }
        return dp[start][fuel] = res;
    }
}
