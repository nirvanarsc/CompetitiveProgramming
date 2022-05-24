package leetcode.weekly_contests.weekly_200_299.weekly_201;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1546 {

    public int maxNonOverlapping(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, 0));
        int res = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }
        return res;
    }
}
