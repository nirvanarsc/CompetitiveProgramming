package leetcode.biweekly_contests.biweekly_49;

import java.util.HashMap;
import java.util.Map;

public class P_1814 {

    private static final int MOD = (int) (1e9 + 7);

    public int countNicePairs(int[] nums) {
        final Map<Long, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            final long curr = num - rev(num);
            res = (res + map.getOrDefault(curr, 0)) % MOD;
            map.merge(curr, 1, Integer::sum);
        }
        return res;
    }

    private static long rev(int n) {
        long res = 0;
        while (n > 0) {
            res = (res * 10) + n % 10;
            n /= 10;
        }
        return res;
    }
}
