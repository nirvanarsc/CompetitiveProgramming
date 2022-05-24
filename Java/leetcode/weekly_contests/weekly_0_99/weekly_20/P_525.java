package leetcode.weekly_contests.weekly_0_99.weekly_20;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_525 {

    public int findMaxLength(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        final int n = nums.length;
        int curr = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            curr += nums[i] == 1 ? 1 : -1;
            res = Math.max(res, i - map.getOrDefault(curr, i));
            map.putIfAbsent(curr, i);
        }
        return res;
    }
}
