package leetcode.weekly_contests.weekly_300_399.weekly_328;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public long countGood(int[] nums, int k) {
        final Map<Integer, Integer> f = new HashMap<>();
        final int n = nums.length;
        long res = 0;
        int j = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr += f.getOrDefault(nums[i], 0);
            f.merge(nums[i], 1, Integer::sum);
            while (curr >= k) {
                res += n - i;
                f.merge(nums[j], -1, Integer::sum);
                curr -= f.get(nums[j++]);
            }
        }
        return res;
    }
}
