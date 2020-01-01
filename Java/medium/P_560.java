package medium;

import java.util.HashMap;
import java.util.Map;

public class P_560 {

    public int subarraySum(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            if (sum == k) {
                res++;
            }
            res += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return res;
    }
}
