package leetcode.biweekly_contests.biweekly_100_199.biweekly_110;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_3 {

    public int minimumSeconds(List<Integer> nums) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        final int n = nums.size();
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(nums.get(i), val -> new ArrayList<>()).add(i);
        }
        int res = (int) 1e9;
        for (List<Integer> v : g.values()) {
            final List<Integer> t = new ArrayList<>();
            t.add(v.get(v.size() - 1) - n);
            t.addAll(v);
            t.add(v.get(0) + n);
            int curr = 0;
            for (int i = 0; i < t.size() - 1; i++) {
                curr = Math.max(curr, t.get(i + 1) - t.get(i));
            }
            res = Math.min(res, curr);
        }
        return res / 2;
    }
}
