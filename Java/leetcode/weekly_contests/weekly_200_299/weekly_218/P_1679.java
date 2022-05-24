package leetcode.weekly_contests.weekly_200_299.weekly_218;

import java.util.Arrays;
import java.util.TreeMap;

public class P_1679 {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length - 1;
        int res = 0;
        while (lo < hi) {
            final int sum = nums[lo] + nums[hi];
            if (sum == k) {
                lo++;
                hi--;
                res++;
            } else if (sum < k) {
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }

    public int maxOperationsTm(int[] nums, int k) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int num : nums) {
            tm.merge(num, 1, Integer::sum);
        }
        int res = 0;
        for (int num : nums) {
            if (tm.merge(k - num, -1, Integer::sum) >= 0) {
                res++;
            }
        }
        return res / 2;
    }
}
