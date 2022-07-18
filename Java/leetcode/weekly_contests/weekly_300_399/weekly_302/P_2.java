package leetcode.weekly_contests.weekly_300_399.weekly_302;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_2 {

    public int maximumSum(int[] nums) {
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int num : nums) {
            g.computeIfAbsent(f(num), val -> new ArrayList<>()).add(num);
        }
        int res = -1;
        for (List<Integer> list : g.values()) {
            final int n = list.size();
            if (n > 1) {
                list.sort(Comparator.naturalOrder());
                res = Math.max(res, list.get(n - 1) + list.get(n - 2));
            }
        }
        return res;
    }

    private static int f(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
