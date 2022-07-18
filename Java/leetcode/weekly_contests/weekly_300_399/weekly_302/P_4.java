package leetcode.weekly_contests.weekly_300_399.weekly_302;

import java.util.Arrays;

public class P_4 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        int g = 0;
        for (int num : numsDivide) {
            g = gcd(g, num);
        }
        Arrays.sort(nums);
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (g % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
