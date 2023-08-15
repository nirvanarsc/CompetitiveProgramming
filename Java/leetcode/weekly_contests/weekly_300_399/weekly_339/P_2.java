package leetcode.weekly_contests.weekly_300_399.weekly_339;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_2 {

    public List<List<Integer>> findMatrix(int[] nums) {
        final List<List<Integer>> res = new ArrayList<>();
        final Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.merge(num, 1, Integer::sum);
        }
        while (!f.isEmpty()) {
            final List<Integer> curr = new ArrayList<>();
            final List<Integer> removals = new ArrayList<>();
            for (Map.Entry<Integer, Integer> e : f.entrySet()) {
                curr.add(e.getKey());
                if (f.merge(e.getKey(), -1, Integer::sum) == 0) {
                    removals.add(e.getKey());
                }
            }
            for (int remove : removals) {
                f.remove(remove);
            }
            res.add(curr);
        }
        return res;
    }
}
