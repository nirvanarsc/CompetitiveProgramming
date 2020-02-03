package hard;

public class P_403 {

    public boolean canCross(int[] stones) {
        return recurse(stones, 0, 0, 1, new Boolean[stones.length][stones.length]);
    }

    private static boolean recurse(int[] stones, int from, int prev, int k, Boolean[][] dp) {
        if (from >= stones.length) {
            return false;
        }
        if (from == stones.length - 1) {
            return true;
        }
        if (dp[from][prev] != null) {
            return dp[from][prev];
        }
        for (int j = from == 0 ? 1 : k - 1; j <= (from == 0 ? 1 : k + 1); j++) {
            for (int t = from + 1; t < stones.length && stones[t] <= stones[from] + j; t++) {
                if (stones[t] == stones[from] + j) {
                    if(recurse(stones, t, from, j, dp)) {
                        return dp[from][prev] = true;
                    }
                }
            }
        }
        return dp[from][prev] = false;
    }
}
