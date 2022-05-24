package leetcode.weekly_contests.weekly_200_299.weekly_204;

import java.util.TreeSet;

public class P_1567 {

    public int getMaxLen(int[] nums) {
        final TreeSet<Integer> ts = new TreeSet<>();
        int res = 0;
        int prev = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length || nums[i] == 0) {
                if (ts.size() % 2 == 0) {
                    res = Math.max(res, i - prev);
                } else {
                    res = Math.max(res, i - ts.first() - 1);
                    res = Math.max(res, i - ts.last() - 1);
                    res = Math.max(res, ts.first() - prev);
                    res = Math.max(res, ts.last() - prev);
                }
                prev = i + 1;
                ts.clear();
            } else if (nums[i] < 0) {
                ts.add(i);
            }
        }
        return res;
    }
}
