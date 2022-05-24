package leetcode.weekly_contests.weekly_0_99.weekly_21;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (i - map.getOrDefault(sum, i) > 1) {
                return true;
            }
            map.putIfAbsent(sum, i);
        }
        return false;
    }
}
