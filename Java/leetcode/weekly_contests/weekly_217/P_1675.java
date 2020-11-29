package leetcode.weekly_contests.weekly_217;

import java.util.TreeSet;

public class P_1675 {

    public int minimumDeviation(int[] nums) {
        final TreeSet<Integer> ts = new TreeSet<>();
        for (int num : nums) {
            ts.add(num % 2 != 0 ? num * 2 : num);
        }
        int res = (int) 1e9;
        while (ts.last() % 2 == 0) {
            final int last = ts.last();
            ts.add(last / 2);
            ts.remove(last);
            res = Math.min(res, ts.last() - ts.first());
        }
        return res;
    }
}
