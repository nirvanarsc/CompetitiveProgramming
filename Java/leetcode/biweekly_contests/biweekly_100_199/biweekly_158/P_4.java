package leetcode.biweekly_contests.biweekly_100_199.biweekly_158;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    private List<List<Integer>> adj;
    private int[] vals;
    private long res;
    private static final int MOD = (int) (1e9 + 7);

    public int goodSubtreeSum(int[] vals, int[] par) {
        final int n = vals.length;
        this.vals = vals;
        adj = new ArrayList<>(n);
        res = 0L;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(par[i]).add(i);
        }
        dfs(0);
        return (int) res;
    }

    private static int getMask(int num) {
        int mask = 0;
        while (num > 0) {
            final int digit = num % 10;
            if ((mask & (1 << digit)) != 0) {
                return -1;
            }
            mask |= 1 << digit;
            num /= 10;
        }
        return mask;
    }

    private Map<Integer, Long> dfs(int u) {
        Map<Integer, Long> uMap = new HashMap<>(Collections.singletonMap(0, 0L));
        final int valMask = getMask(vals[u]);
        long curr = 0L;
        if (valMask != -1) {
            uMap.put(valMask, (long) vals[u]);
            curr = vals[u];
        }
        for (int v : adj.get(u)) {
            final Map<Integer, Long> vMap = dfs(v);
            final Map<Integer, Long> nextUMap = new HashMap<>();
            for (Map.Entry<Integer, Long> uEntry : uMap.entrySet()) {
                for (Map.Entry<Integer, Long> vEntry : vMap.entrySet()) {
                    final int mask1 = uEntry.getKey();
                    final long score1 = uEntry.getValue();
                    final int mask2 = vEntry.getKey();
                    final long score2 = vEntry.getValue();
                    if ((mask1 & mask2) == 0) {
                        final int newMask = mask1 | mask2;
                        final long newScore = score1 + score2;
                        final long merged = nextUMap.merge(newMask, newScore, Math::max);
                        curr = Math.max(curr, merged);
                    }
                }
            }
            uMap = nextUMap;
        }
        res = (res + curr) % MOD;
        return uMap;
    }
}
