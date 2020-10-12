package leetcode.biweekly_contests.biweekly_35;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1590 {

    public int minSubarray(int[] nums, int p) {
        int target = 0;
        for (int num : nums) {
            target = (target + num) % p;
        }
        if (target == 0) {
            return 0;
        }
        final int n = nums.length;
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        int currMod = 0, res = n;
        for (int i = 0; i < n; i++) {
            currMod = (currMod + nums[i]) % p;
            final int mod = Math.floorMod(currMod - target, p);
            if (map.containsKey(mod)) {
                res = Math.min(res, i - map.get(mod));
            }
            map.put(currMod, i);
        }
        return res == n ? -1 : res;
    }
}
