package leetcode.weekly_contests.weekly_300_399.weekly_363;

import java.util.List;

public class P_3 {

    public int maxNumberOfAlloys(int n, int k, int budget,
                                 List<List<Integer>> composition,
                                 List<Integer> stock,
                                 List<Integer> cost) {
        int res = 0;
        for (int i = 0; i < k; i++) {
            int lo = 0;
            int hi = (int) 1e9;
            while (lo < hi) {
                final int mid = lo + hi + 1 >>> 1;
                long need = 0L;
                for (int j = 0; j < n; j++) {
                    final long take = Math.max(0L, (long) mid * composition.get(i).get(j) - stock.get(j));
                    need += take * cost.get(j);
                }
                if (need > budget) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
                res = Math.max(res, lo);
            }
        }
        return res;
    }
}
