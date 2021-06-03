package binarysearch.weekly_35;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    private static final int MOD = (int) (1e9 + 7);

    public int solve(int[] nums) {
        final Map<Long, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            final long curr = num - rev(num);
            map.merge(curr, 1, Integer::sum);
            res = (res + map.getOrDefault(curr, 0)) % MOD;
        }
        return res;
    }

    private static long rev(int num) {
        long res = 0;
        while (num > 0) {
            res = (res * 10) + num % 10;
            num /= 10;
        }
        return res;
    }
}
