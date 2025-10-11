package leetcode.weekly_contests.weekly_400_499.weekly_402;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public long maximumTotalDamage(int[] power) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.merge(p, 1, Integer::sum);
        }
        final List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);
        final int n = keys.size();
        final long[] dp = new long[n];
        dp[0] = (long) freq.get(keys.get(0)) * keys.get(0);
        for (int i = 1; i < n; i++) {
            long curr = (long) freq.get(keys.get(i)) * keys.get(i);
            final int prev = upperBound(keys, keys.get(i) - 3, i);
            if (keys.get(prev) < (keys.get(i) - 2)) {
                curr += dp[prev];
            }
            dp[i] = Math.max(dp[i - 1], curr);
        }
        return dp[n - 1];
    }

    private static int upperBound(List<Integer> list, int target, int to) {
        int lo = 0;
        int hi = to - 1;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (list.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }
}
