package leetcode.biweekly_contests.biweekly_28;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1477 {

    public int minSumOfLengths(int[] arr, int target) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        int sum = 0, left = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                left = Math.min(left, i - map.get(sum - target));
            }
            if (map.containsKey(sum + target) && left < Integer.MAX_VALUE) {
                res = Math.min(res, map.get(sum + target) - i + left);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
