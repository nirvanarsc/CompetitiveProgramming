package leetcode.weekly_contests.weekly_300_399.weekly_363;

import java.util.List;

public class P_4 {

    public long maximumSum(List<Integer> nums) {
        long res = 0;
        for (int i = 1; i <= nums.size(); i++) {
            int u = 1;
            long curr = 0;
            while ((i * u * u) - 1 < nums.size()) {
                curr += nums.get((i * u * u) - 1);
                u++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
