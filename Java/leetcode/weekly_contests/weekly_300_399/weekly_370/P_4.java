package leetcode.weekly_contests.weekly_300_399.weekly_370;

import java.util.Map;
import java.util.TreeMap;

public class P_4 {

    public long maxBalancedSubsequenceSum(int[] nums) {
        final int n = nums.length;
        final TreeMap<Integer, Long> map = new TreeMap<>();
        long res = (long) -1e9;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                res = Math.max(res, nums[i]);
            } else {
                long curr = nums[i];
                final Map.Entry<Integer, Long> e = map.floorEntry(nums[i] - i);
                curr += e != null ? e.getValue() : 0;
                Map.Entry<Integer, Long> c = map.higherEntry(nums[i] - i);
                while (c != null && c.getValue() < curr) {
                    map.remove(c.getKey());
                    c = map.higherEntry(nums[i] - i);
                }
                map.merge(nums[i] - i, curr, Long::max);
                res = Math.max(res, curr);
            }
        }
        return res;
    }
}
