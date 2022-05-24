package leetcode.weekly_contests.weekly_200_299.weekly_224;

import java.util.HashMap;
import java.util.Map;

public class P_1726 {

    public int tupleSameProduct(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        int res = 0;
        for (int val : map.values()) {
            res += 4 * val * (val - 1);
        }
        return res;
    }
}
