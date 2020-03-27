package weekly_contests.weekly_82;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_826 {

    static class Pair {
        int diff;
        int profit;

        Pair(int diff, int profit) {
            this.diff = diff;
            this.profit = profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        final List<Pair> jobs = new ArrayList<>();
        int res = 0, i = 0, best = 0;
        for (int j = 0; j < profit.length; ++j) {
            jobs.add(new Pair(difficulty[j], profit[j]));
        }
        jobs.sort(Comparator.comparing(a -> a.diff));
        Arrays.sort(worker);
        for (int ability : worker) {
            while (i < profit.length && ability >= jobs.get(i).diff) {
                best = Math.max(jobs.get(i++).profit, best);
            }
            res += best;
        }
        return res;
    }

    public int maxProfitAssignmentTM(int[] difficulty, int[] profit, int[] worker) {
        final TreeMap<Integer, Integer> map = new TreeMap<>(Collections.singletonMap(0, 0));
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        int best = 0, res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            best = Math.max(entry.getValue(), best);
            map.put(entry.getKey(), best);
        }
        for (int w : worker) {
            res += map.floorEntry(w).getValue();
        }
        return res;
    }
}
