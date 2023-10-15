package leetcode.weekly_contests.weekly_300_399.weekly_363;

import java.util.Comparator;
import java.util.List;

public class P_2 {

    public int countWays(List<Integer> nums) {
        nums.sort(Comparator.naturalOrder());
        final int n = nums.size();
        int res = nums.get(0) == 0 ? 0 : 1;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            curr++;
            if (curr > nums.get(i) && (i + 1 == n || curr < nums.get(i + 1))) {
                res++;
            }
        }
        return res;
    }
}
