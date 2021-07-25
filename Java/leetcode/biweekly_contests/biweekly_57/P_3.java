package leetcode.biweekly_contests.biweekly_57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P_3 {

    public List<List<Long>> splitPainting(int[][] segments) {
        final int max = (int) (1e5 + 5);
        final long[] pre = new long[max];
        final Set<Integer> starts = new HashSet<>();
        final Set<Integer> ends = new HashSet<>();
        for (int[] s : segments) {
            starts.add(s[0]);
            ends.add(s[1]);
            pre[s[0]] += s[2];
            pre[s[1]] -= s[2];
        }
        ends.retainAll(starts);
        final long[] calc = new long[max];
        long curr = 0;
        for (int i = 0; i < max; i++) {
            curr += pre[i];
            calc[i] = curr;
        }
        final List<List<Long>> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            if (calc[i] > 0) {
                int j = i;
                int start = i;
                while (j < max && calc[j] == calc[i]) {
                    if (ends.contains(j) && start < j) {
                        res.add(Arrays.asList((long) start, (long) j, calc[i]));
                        start = j;
                    }
                    j++;
                }
                res.add(Arrays.asList((long) start, (long) j, calc[i]));
                i = j - 1;
            }
        }
        return res;
    }
}
