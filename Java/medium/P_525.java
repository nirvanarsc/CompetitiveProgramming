package medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_525 {

    public int findMaxLength(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? 1 : -1;
            res = Math.max(res, i - map.getOrDefault(sum, i));
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}
