package leetcode.weekly_contests.weekly_300_399.weekly_356;

import java.util.HashSet;
import java.util.Set;

public class P_2 {

    public int countCompleteSubarrays(int[] nums) {
        final Set<Integer> distinct = new HashSet<>();
        final int n = nums.length;
        for (int num : nums) {
            distinct.add(num);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            final Set<Integer> curr = new HashSet<>();
            for (int j = i; j < n; j++) {
                curr.add(nums[j]);
                if (curr.size() == distinct.size()) {
                    res++;
                }
            }
        }
        return res;
    }
}
