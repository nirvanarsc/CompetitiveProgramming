package binarysearch.weekly_31;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_2 {

    public int[] solve(int[] nums, int[] queries, int w) {
        int n = nums.length;
        final Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
        }
        final Map<Integer, Integer> f = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            final int key = e.getKey();
            int curr = 0;
            int right = -1;
            for (int idx : e.getValue()) {
                final int l = Math.max(idx - w + 1, right + 1);
                final int r = Math.min(idx, n - w);
                curr += r - l + 1;
                right = r;
            }
            f.merge(key, curr, Integer::sum);
        }
        n = queries.length;
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = f.get(queries[i]);
        }
        return res;
    }
}
