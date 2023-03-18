package leetcode.biweekly_contests.biweekly_0_99.biweekly_35;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1590 {

    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for (int num : nums) {
            total = (total + num) % p;
        }
        if (total == 0) {
            return 0;
        }
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        int curr = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            curr = (curr + nums[i]) % p;
            final int target = (curr - total + p) % p;
            if (map.containsKey(target)) {
                res = Math.min(res, i - map.get(target));
            }
            map.put(target, i);
        }
        return res == nums.length ? -1 : res;
    }
}
