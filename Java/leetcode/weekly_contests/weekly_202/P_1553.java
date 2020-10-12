package leetcode.weekly_contests.weekly_202;

import java.util.HashMap;
import java.util.Map;

public class P_1553 {

    public int minDays(int n) {
        return dfs(n, new HashMap<>());
    }

    private static int dfs(int n, Map<Integer, Integer> dp) {
        if (n <= 1) {
            return n;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        final int res = 1 + Math.min(n % 2 + dfs(n / 2, dp), n % 3 + dfs(n / 3, dp));
        dp.put(n, res);
        return res;
    }
}
