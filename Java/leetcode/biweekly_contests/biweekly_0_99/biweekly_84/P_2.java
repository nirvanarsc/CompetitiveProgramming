package leetcode.biweekly_contests.biweekly_0_99.biweekly_84;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public long countBadPairs(int[] nums) {
        long good = 0;
        final Map<Integer, Integer> f = new HashMap<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            good += f.getOrDefault(nums[i] - i, 0);
            f.merge(nums[i] - i, 1, Integer::sum);
        }
        return ((long) n * (n - 1) / 2) - good;
    }
}
