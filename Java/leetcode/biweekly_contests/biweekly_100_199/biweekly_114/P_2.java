package leetcode.biweekly_contests.biweekly_100_199.biweekly_114;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public int minOperations(int[] nums) {
        final Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.merge(num, 1, Integer::sum);
        }
        int res = 0;
        for (int v : f.values()) {
            if (v % 3 == 0) {
                res += v / 3;
            } else if (v % 3 == 2) {
                res += (v / 3) + 1;
            } else {
                if (v == 1) {
                    return -1;
                }
                res += 2 + (v - 4) / 3;
            }
        }
        return res;
    }
}
