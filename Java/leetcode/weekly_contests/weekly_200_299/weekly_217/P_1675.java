package leetcode.weekly_contests.weekly_200_299.weekly_217;

import java.util.TreeSet;

public class P_1675 {

    @SuppressWarnings("ConstantConditions")
    public int minimumDeviation(int[] nums) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int num : nums) {
            ts.add(num % 2 != 0 ? num * 2 : num);
        }
        int res = ts.last() - ts.first();
        while (ts.last() % 2 == 0) {
            ts.add(ts.pollLast() / 2);
            res = Math.min(res, ts.last() - ts.first());
        }
        return res;
    }
}
