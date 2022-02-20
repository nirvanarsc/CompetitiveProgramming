package leetcode.weekly_contests.weekly_281;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    public long countPairs(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<>();
        final List<Integer> fact = new ArrayList<>();
        for (int p = 1; p * p <= k; p++) {
            if (k % p == 0) {
                fact.add(p);
                if (p != (k / p)) {
                    fact.add(k / p);
                }
            }
        }
        long res = 0;
        for (int num : nums) {
            final int gcd = gcd(num, k);
            for (int f : fact) {
                if (((long) gcd * f) % k == 0) {
                    res += map.getOrDefault(f, 0);
                }
            }
            map.merge(gcd, 1, Integer::sum);
        }
        return res;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
