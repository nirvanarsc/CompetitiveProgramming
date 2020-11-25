package binarysearch.weekly_34;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public boolean solve(int[] nums, int k) {
        return dfs(nums, 0, 0, k, new HashMap<>()) == k;
    }

    private static int dfs(int[] nums, int idx, int sum, int k, Map<String, Integer> dp) {
        if (idx >= nums.length) {
            return sum;
        }
        final String key = idx + "," + sum;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = dfs(nums, idx + 1, sum, k, dp);
        if (sum + nums[idx] <= k) {
            res = Math.max(res, dfs(nums, idx + 2, sum + nums[idx], k, dp));
        }
        dp.put(key, res);
        return res;
    }
}
