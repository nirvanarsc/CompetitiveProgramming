package leetcode.weekly_contests.weekly_300_399.weekly_335;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_3 {

    public int findValidSplit(int[] nums) {
        final int n = nums.length;
        final Map<Integer, Integer> g = new HashMap<>();
        final Map<Integer, List<Integer>> primes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int p = 2; p * p <= nums[i]; p++) {
                if (num % p == 0) {
                    g.merge(p, i, Integer::max);
                    primes.computeIfAbsent(i, val -> new ArrayList<>()).add(p);
                    while (num % p == 0) {
                        num /= p;
                    }
                }
            }
            if (num > 1) {
                g.merge(num, i, Integer::max);
                primes.computeIfAbsent(i, val -> new ArrayList<>()).add(num);
            }
        }
        final Set<Integer> curr = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            curr.addAll(primes.getOrDefault(i, Collections.emptyList()));
            if (ok(i, curr, g)) {
                return i;
            }

        }
        return -1;
    }

    private static boolean ok(int i, Set<Integer> primes, Map<Integer, Integer> g) {
        for (int p : primes) {
            if (i < g.get(p)) {
                return false;
            }
        }
        return true;
    }
}
