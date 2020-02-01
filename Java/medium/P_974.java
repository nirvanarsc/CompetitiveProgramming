package medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_974 {

    public int subarraysDivByKPrimitive(int[] nums, int k) {
        final int[] map = new int[k];
        map[0] = 1;
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            final int r = sum % k < 0 ? sum % k + k : sum % k;
            res += map[r]++;
        }
        return res;
    }

    public int subarraysDivByK(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, 1));
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(Math.floorMod(sum, k), 0);
            map.merge(Math.floorMod(sum, k), 1, Integer::sum);
        }
        return res;
    }
}
