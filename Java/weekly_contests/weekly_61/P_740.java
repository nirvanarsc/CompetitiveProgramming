package weekly_contests.weekly_61;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_740 {

    public int deleteAndEarnBottomUp(int[] nums) {
        final int[] count = new int[10001];
        for (int n : nums) {
            count[n] += n;
        }
        final int[] dp = new int[10003];
        for (int i = 10000; i >= 0; i--) {
            dp[i] = Math.max(count[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    public int deleteAndEarnTopDown(int[] nums) {
        final Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.merge(num, num, Integer::sum);
        }
        return pick(new ArrayList<>(counter.keySet()), 0, counter, new Integer[counter.size()]);
    }

    private static int pick(List<Integer> keys, int index, Map<Integer, Integer> counter, Integer[] dp) {
        if (index >= keys.size()) {
            return 0;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        final int currentKey = keys.get(index);
        int pickProfit = counter.get(currentKey);
        if (index != keys.size() - 1) {
            pickProfit += counter.containsKey(currentKey + 1)
                          ? pick(keys, index + 2, counter, dp)
                          : pick(keys, index + 1, counter, dp);
        }
        final int noPick = pick(keys, index + 1, counter, dp);

        return dp[index] = Math.max(pickProfit, noPick);
    }
}
