package medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) {
                runningSum %= k;
            }
            if (map.containsKey(runningSum) && i - map.get(runningSum) > 1) {
                return true;
            }
            map.putIfAbsent(runningSum, i);
        }
        return false;
    }
}
