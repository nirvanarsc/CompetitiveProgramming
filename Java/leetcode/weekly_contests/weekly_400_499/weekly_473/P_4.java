package leetcode.weekly_contests.weekly_400_499.weekly_473;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public long numGoodSubarrays(int[] nums, int k) {
        final int n = nums.length;
        long res = subarraysDivByK(nums, k);
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            final int len = j - i;
            for (int v = 1; v < len; v++) {
                if (((long) v * nums[i]) % k == 0) {
                    res -= len - v;
                }
            }
            i = j - 1;
        }
        return res;
    }

    private static long subarraysDivByK(int[] nums, int k) {
        final Map<Integer, Long> f = new HashMap<>(Collections.singletonMap(0, 1L));
        int curr = 0;
        long res = 0;
        for (int num : nums) {
            curr = (curr + num) % k;
            res += f.getOrDefault(curr, 0L);
            f.merge(curr, 1L, Long::sum);
        }
        return res;
    }
}
