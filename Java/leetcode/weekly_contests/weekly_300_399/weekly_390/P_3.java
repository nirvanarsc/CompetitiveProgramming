package leetcode.weekly_contests.weekly_300_399.weekly_390;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P_3 {

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        final int n = nums.length;
        final TreeMap<Long, Integer> tm = new TreeMap<>();
        final Map<Integer, Long> f = new HashMap<>();
        final long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            if (tm.merge(f.getOrDefault(nums[i], 0L), -1, Integer::sum) == 0) {
                tm.remove(f.get(nums[i]));
            }
            tm.merge(f.merge(nums[i], (long) freq[i], Long::sum), 1, Integer::sum);
            res[i] = tm.lastKey();
        }
        return res;
    }
}
