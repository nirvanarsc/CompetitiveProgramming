package leetcode.weekly_contests.weekly_300_399.weekly_375;

import java.util.HashMap;
import java.util.Map;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfGoodPartitions(int[] nums) {
        final Map<Integer, Integer> last = new HashMap<>();
        final int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            last.putIfAbsent(nums[i], i);
        }
        long res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            j = Math.max(j, last.get(nums[i]));
            if (i == j) {
                if (res == 0) {
                    res = 1;
                } else {
                    res = res * 2 % MOD;
                }
            }
        }
        return (int) res;
    }
}
