package binarysearch.weekly_50;

import java.util.HashMap;
import java.util.Map;

public class P_1 {

    public int solve(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            for (int j = 0; j < Integer.SIZE; j++) {
                res += map.getOrDefault((1 << j) - num, 0);
            }
            map.merge(num, 1, Integer::sum);
        }
        return res;
    }
}
