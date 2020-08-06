package weekly_contests.weekly_39;

import java.util.List;
import java.util.TreeSet;

public class P_632 {

    private static class Pair {
        int val;
        int idx;
        int listIdx;

        Pair(int val, int idx, int listIdx) {
            this.val = val;
            this.idx = idx;
            this.listIdx = listIdx;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        final TreeSet<Pair> ts = new TreeSet<>((a, b) -> a.val == b.val ? Integer.compare(a.listIdx, b.listIdx)
                                                                        : Integer.compare(a.val, b.val));
        final int k = nums.size();
        for (int i = 0; i < k; i++) {
            ts.add(new Pair(nums.get(i).get(0), 0, i));
        }
        final int[] res = { (int) -1e6, (int) 1e6 };
        while (ts.size() == k) {
            if (ts.last().val - ts.first().val < res[1] - res[0]) {
                res[0] = ts.first().val;
                res[1] = ts.last().val;
            }
            final Pair pair = ts.pollFirst();
            if (pair != null && pair.idx + 1 < nums.get(pair.listIdx).size()) {
                ts.add(new Pair(nums.get(pair.listIdx).get(pair.idx + 1), pair.idx + 1, pair.listIdx));
            }
        }
        return res;
    }
}

