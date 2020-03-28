package weekly_contests.weekly_80;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_818 {

    public int racecar(int target) {
        final Set<String> visited = new HashSet<>(Collections.singletonList(0 + " " + 1));
        final Deque<int[]> pq = new ArrayDeque<>(Collections.singletonList(new int[] { 0, 1 }));
        int res = 0;
        while (!pq.isEmpty()) {
            for (int k = pq.size(); k > 0; k--) {
                final int[] curr = pq.removeFirst();
                if (curr[0] == target) {
                    return res;
                }
                int[] nxt = { curr[0] + curr[1], curr[1] << 1 };
                String key = nxt[0] + " " + nxt[1];
                if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
                    pq.offerLast(nxt);
                    visited.add(key);
                }
                nxt = new int[] { curr[0], curr[1] > 0 ? -1 : 1 };
                key = nxt[0] + " " + nxt[1];
                if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
                    pq.offerLast(nxt);
                    visited.add(key);
                }
            }
            res++;
        }
        return -1;
    }

    public int racecarTopDown(int target) {
        return racecar(target, new Integer[target + 1]);
    }

    private static int racecar(int target, Integer[] dp) {
        if (dp[target] != null) {
            return dp[target];
        }

        int acc = Integer.MAX_VALUE, m = 1, j = 1;
        while (j < target) {
            for (int q = 0, p = 0; p < j; p = (1 << ++q) - 1) {
                acc = Math.min(acc, m + 1 + q + 1 + racecar(target - (j - p), dp));
            }
            j = (1 << ++m) - 1;
        }
        final int reverse = m + (target == j ? 0 : 1 + racecar(j - target, dp));

        return dp[target] = Math.min(acc, reverse);
    }
}
