package leetcode.weekly_contests.weekly_200_299.weekly_215;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1658 {

    public int minOperations(int[] nums, int x) {
        final int n = nums.length;
        final Map<Integer, Integer> pre = new HashMap<>(Collections.singletonMap(0, 0));
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pre.put(sum, i + 1);
        }
        int res = pre.getOrDefault(x, (int) 1e9);
        sum = 0;
        for (int i = n - 1, j = 1; i >= 0; i--, j++) {
            sum += nums[i];
            final Integer complement = pre.get(x - sum);
            if (complement != null && complement + j <= n) {
                res = Math.min(res, complement + j);
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
