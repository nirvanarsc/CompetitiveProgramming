package leetcode.weekly_contests.weekly_300_399.weekly_352;

import java.util.TreeMap;

public class P_3 {

    public long continuousSubarrays(int[] nums) {
        final int n = nums.length;
        final TreeMap<Integer, Integer> f = new TreeMap<>();
        long res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            f.merge(nums[i], 1, Integer::sum);
            while (!f.isEmpty() && f.lastKey() - f.firstKey() > 2) {
                if (f.merge(nums[j], -1, Integer::sum) == 0) {
                    f.remove(nums[j]);
                }
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}
