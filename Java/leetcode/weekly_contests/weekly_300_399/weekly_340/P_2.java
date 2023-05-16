package leetcode.weekly_contests.weekly_300_399.weekly_340;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public long[] distance(int[] nums) {
        final int n = nums.length;
        final Map<Integer, Long> l = new HashMap<>();
        final Map<Integer, Long> lf = new HashMap<>();
        final Map<Integer, Long> r = new HashMap<>();
        final Map<Integer, Long> rf = new HashMap<>();
        final long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            r.merge(nums[i], (long) i, Long::sum);
            rf.merge(nums[i], 1L, Long::sum);
        }
        for (int i = 0; i < n; i++) {
            r.merge(nums[i], (long) -i, Long::sum);
            rf.merge(nums[i], -1L, Long::sum);
            res[i] = lf.getOrDefault(nums[i], 0L) * i - l.getOrDefault(nums[i], 0L)
                     + r.get(nums[i]) - rf.get(nums[i]) * i;
            lf.merge(nums[i], 1L, Long::sum);
            l.merge(nums[i], (long) i, Long::sum);
        }
        return res;
    }
}
