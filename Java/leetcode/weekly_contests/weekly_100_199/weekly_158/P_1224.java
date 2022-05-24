package leetcode.weekly_contests.weekly_100_199.weekly_158;

import java.util.HashMap;
import java.util.Map;

public class P_1224 {

    public int maxEqualFreq(int[] nums) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        final Map<Integer, Integer> freqMap = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            final int freq = countMap.merge(nums[i], 1, Integer::sum);
            final int count = freqMap.merge(freq, 1, Integer::sum) * freq;
            if (count == i + 1 && i != nums.length - 1) {
                res = Math.max(res, i + 2);
            } else if (count == i) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}
