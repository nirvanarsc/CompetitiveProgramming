package leetcode.biweekly_contests.biweekly_62;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public int waysToPartition(int[] nums, int k) {
        final int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        final Map<Long, Integer> left = new HashMap<>();
        final Map<Long, Integer> right = new HashMap<>();
        long curr = 0;
        for (int i = 0; i < n - 1; i++) {
            curr += nums[i];
            right.merge(sum - 2 * curr, 1, Integer::sum);
        }
        int res = right.getOrDefault(0L, 0);
        curr = 0;
        for (long num : nums) {
            res = Math.max(res, left.getOrDefault(num - k, 0) +
                                right.getOrDefault(-num + k, 0));
            curr += num;
            left.merge(sum - 2 * curr, 1, Integer::sum);
            right.merge(sum - 2 * curr, -1, Integer::sum);
        }
        return res;
    }
}
