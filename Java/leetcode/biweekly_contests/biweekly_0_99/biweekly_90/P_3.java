package leetcode.biweekly_contests.biweekly_0_99.biweekly_90;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public int destroyTargets(int[] nums, int space) {
        final Map<Integer, Integer> f = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, f.merge(num % space, 1, Integer::sum));
        }
        int res = (int) 1e9;
        for (int num : nums) {
            if (f.get(num % space) == max) {
                res = Math.min(res, num);
            }
        }
        return res;
    }
}
