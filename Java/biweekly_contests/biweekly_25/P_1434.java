package biweekly_contests.biweekly_25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1434 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberWays(List<List<Integer>> hats) {
        final int n = hats.size();
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i)) {
                map.computeIfAbsent(hat, v -> new ArrayList<>()).add(i);
            }
        }
        final List<Integer> uniqueHats = new ArrayList<>(map.keySet());
        return dfs(0, (1 << n) - 1, 0, uniqueHats, map, new Integer[uniqueHats.size()][1 << n]);
    }

    private static int dfs(int mask, int target, int idx, List<Integer> hats,
                           Map<Integer, List<Integer>> map, Integer[][] dp) {
        if (idx == hats.size()) {
            return mask == target ? 1 : 0;
        }
        if (dp[idx][mask] != null) {
            return dp[idx][mask];
        }
        int res = dfs(mask, target, idx + 1, hats, map, dp);
        for (int person : map.get(hats.get(idx))) {
            if ((mask & (1 << person)) == 0) {
                res = (res + dfs(mask | (1 << person), target, idx + 1, hats, map, dp)) % MOD;
            }
        }
        return dp[idx][mask] = res;
    }
}
