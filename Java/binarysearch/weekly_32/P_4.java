package binarysearch.weekly_32;

import java.util.Arrays;

public class P_4 {

    public double solve(int[] nums) {
        int lo = 0;
        int hi = (int) 2e9;
        Arrays.sort(nums);
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (!f(nums, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo * 0.5;
    }

    private static boolean f(int[] nums, int diam) {
        int res = 0;
        int end = (int) -2e9;
        for (int num : nums) {
            if (num > end) {
                end = num + diam;
                res++;
            }
        }
        return res < 4;
    }
}
