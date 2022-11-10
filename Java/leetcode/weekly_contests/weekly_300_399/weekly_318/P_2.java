package leetcode.weekly_contests.weekly_300_399.weekly_318;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public long maximumSubarraySum(int[] nums, int k) {
        final Map<Integer, Integer> f = new HashMap<>();
        final int n = nums.length;
        long s = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            f.merge(nums[i], 1, Integer::sum);
            s += nums[i];
            if (i >= k) {
                s -= nums[i - k];
                if (f.merge(nums[i - k], -1, Integer::sum) == 0) {
                    f.remove(nums[i - k]);
                }
            }
            if (i >= k - 1) {
                if (f.size() == k) {
                    res = Math.max(res, s);

                }
            }
        }
        return res;
    }
}
