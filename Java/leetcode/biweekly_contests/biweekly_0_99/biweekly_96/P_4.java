package leetcode.biweekly_contests.biweekly_0_99.biweekly_96;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    static Map<String, Integer> dp;

    public boolean isReachable(int targetX, int targetY) {
        dp = new HashMap<>();
        return dfs(targetX, targetY) == 1;
    }

    private static int dfs(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        }
        if ((x & (x - 1)) == 0 || (y & (y - 1)) == 0) {
            return 1;
        }
        final String key = x + "," + y;
        final Integer prev = dp.get(key);
        if (prev != null) {
            return prev;
        }
        int res = 0;
        if (x % 2 == 0) {
            res = Math.max(res, dfs(x / 2, y));
        }
        if (y % 2 == 0) {
            res = Math.max(res, dfs(x, y / 2));
        }
        if (y > x) {
            res = Math.max(res, dfs(x, y % x));
        }
        if (x > y) {
            res = Math.max(res, dfs(x % y, y));
        }
        dp.put(key, res);
        return res;
    }
}
