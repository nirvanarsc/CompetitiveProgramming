package leetcode.weekly_contests.weekly_300_399.weekly_359;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P_3 {

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        offers.sort(Comparator.comparingInt(a -> a.get(0)));
        n = offers.size();
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, (int) -1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            final int next = lowerBound(offers, offers.get(i).get(1) + 1);
            dp[next] = Math.max(dp[next], dp[i] + offers.get(i).get(2));
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        return dp[n];
    }

    private static int lowerBound(List<List<Integer>> offers, int target) {
        int lo = 0;
        int hi = offers.size();
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (offers.get(mid).get(0) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
