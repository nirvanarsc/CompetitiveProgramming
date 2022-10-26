package leetcode.weekly_contests.weekly_0_99.weekly_21;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        final int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % k;
            final Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
