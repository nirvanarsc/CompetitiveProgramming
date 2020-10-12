package leetcode.weekly_contests.weekly_33;

import java.util.HashMap;
import java.util.Map;

public class P_594 {

    public int findLHS(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (map.containsKey(e.getKey() - 1)) {
                res = Math.max(res, e.getValue() + map.get(e.getKey() - 1));
            }
        }
        return res;
    }
}
