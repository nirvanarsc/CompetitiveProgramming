package biweekly_contests.biweekly_25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1434 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberWays(List<List<Integer>> hats) {
        final int n = hats.size();
        final Map<Integer, List<Integer>> hatIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i)) {
                hatIndex.computeIfAbsent(hat, v -> new ArrayList<>()).add(i);
            }
        }
        return recurse(0, 1, (1 << n) - 1, hatIndex, new Integer[1 << n][41]);
    }

    public int recurse(int mask, int i, int endState, Map<Integer, List<Integer>> hatIndex, Integer[][] dp) {
        if (mask == endState) {
            return 1;
        }
        if (i > 40) {
            return 0;
        }
        if (dp[mask][i] != null) {
            return dp[mask][i];
        }
        int ways = recurse(mask, i + 1, endState, hatIndex, dp);
        for (int person : hatIndex.getOrDefault(i, Collections.emptyList())) {
            if ((mask & (1 << person)) == 0) {
                ways = (ways + recurse(mask | (1 << person), i + 1, endState, hatIndex, dp)) % MOD;
            }
        }
        return dp[mask][i] = ways;
    }
}
