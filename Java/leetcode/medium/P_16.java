package leetcode.medium;

import java.util.Arrays;

public class P_16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = (int) 1e9;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                final int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }
}
