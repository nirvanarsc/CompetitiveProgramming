package leetcode.weekly_contests.weekly_285;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public int countHillValley(int[] nums) {
        final List<Integer> list = new ArrayList<>();
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
        }
        int res = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i - 1) < list.get(i) && list.get(i) > list.get(i + 1)) {
                res++;
            }
            if (list.get(i - 1) > list.get(i) && list.get(i) < list.get(i + 1)) {
                res++;
            }
        }
        return res;
    }

}
