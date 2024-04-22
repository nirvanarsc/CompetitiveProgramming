package leetcode.biweekly_contests.biweekly_100_199.biweekly_119;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public int maxSubarrayLength(int[] nums, int k) {
        final Map<Integer, Integer> f = new HashMap<>();
        final int n = nums.length;
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            f.merge(nums[i], 1, Integer::sum);
            while (f.get(nums[i]) > k) {
                f.merge(nums[j++], -1, Integer::sum);
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
