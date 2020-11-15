package leetcode.weekly_contests.weekly_215;

import java.util.HashMap;
import java.util.Map;

public class P_1658 {

    public int minOperations(int[] nums, int x) {
        final Map<Integer, Integer> prefix = new HashMap<>();
        final int n = nums.length;
        int pre = 0;
        int res = (int) 1e9;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (pre == x) {
                res = Math.min(res, i + 1);
            }
            prefix.put(pre, i + 1);
        }
        int suff = 0;
        for (int i = nums.length - 1, j = 1; i >= 0; i--, j++) {
            suff += nums[i];
            if (suff == x) {
                res = Math.min(res, j);
            }
            if (prefix.containsKey(x - suff)) {
                final int other = prefix.get(x - suff);
                if (other <= n - j) {
                    res = Math.min(res, j + prefix.get(x - suff));
                }
            }
        }
        return res == (int) 1e9 ? -1 : res;
    }
}
