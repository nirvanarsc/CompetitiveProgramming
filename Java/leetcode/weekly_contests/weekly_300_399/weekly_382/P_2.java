package leetcode.weekly_contests.weekly_300_399.weekly_382;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public int maximumLength(int[] nums) {
        final Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.merge(num, 1, Integer::sum);
        }
        int res = 1;
        if (f.containsKey(1)) {
            res = f.get(1);
            if (res % 2 == 0) {
                res--;
            }
        }
        for (int num : f.keySet()) {
            if (f.get(num) == 1 || num == 1) {
                continue;
            }
            int curr = 0;
            while (f.getOrDefault(num, 0) > 1) {
                final long next = (long) num * num;
                if (next > (int) 2e9) {
                    break;
                }
                num = (int) next;
                curr += 2;
            }
            curr += f.containsKey(num) ? 1 : -1;
            res = Math.max(res, curr);
        }
        return res;
    }
}
