package leetcode.biweekly_contests.biweekly_100_199.biweekly_111;

import java.util.List;

public class P_1 {

    public int countPairs(List<Integer> nums, int target) {
        int res = 0;
        final int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    res++;
                }
            }
        }
        return res;
    }
}
