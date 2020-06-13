package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        return dfs(nums, 0, new HashMap<>());
    }

    private static List<Integer> dfs(int[] nums, int idx, Map<Integer, List<Integer>> dp) {
        if (dp.containsKey(idx)) {
            return dp.get(idx);
        }
        List<Integer> res = new ArrayList<>();
        final int div = idx == 0 ? 1 : nums[idx - 1];
        for (int k = idx; k < nums.length; k++) {
            if (nums[k] % div == 0) {
                final List<Integer> next = new ArrayList<>(dfs(nums, k + 1, dp));
                next.add(nums[k]);
                if (next.size() > res.size()) {
                    res = next;
                }
            }
        }
        dp.put(idx, res);
        return res;
    }
}
