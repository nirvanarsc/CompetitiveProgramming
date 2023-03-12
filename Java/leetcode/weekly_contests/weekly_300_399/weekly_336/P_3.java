package leetcode.weekly_contests.weekly_300_399.weekly_336;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public long beautifulSubarrays(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, 1));
        long res = 0;
        int curr = 0;
        for (int num : nums) {
            curr ^= num;
            res += map.getOrDefault(curr, 0);
            map.merge(curr, 1, Integer::sum);
        }
        return res;
    }
}
