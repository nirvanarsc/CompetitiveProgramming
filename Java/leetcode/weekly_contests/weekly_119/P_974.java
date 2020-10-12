package leetcode.weekly_contests.weekly_119;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_974 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int subarraysDivByK(int[] A, int K) {
        final int[] remainders = new int[K];
        remainders[0] = 1;
        int res = 0, sum = 0;
        for (int num : A) {
            sum += num;
            final int r = ((sum % K) + K) % K;
            res += remainders[r];
            remainders[r]++;
        }
        return res;
    }

    public int subarraysDivByKMap(int[] nums, int k) {
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
