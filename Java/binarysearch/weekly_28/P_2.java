package binarysearch.weekly_28;

public class P_2 {

    public int solve(int[] nums) {
        final int n = nums.length;
        if (n < 2) {
            return n;
        }
        final int[] preMax = new int[n];
        final int[] suffMin = new int[n];
        preMax[0] = nums[0];
        suffMin[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                final int min = suffMin[1];
                if (nums[0] < min) {
                    res++;
                }
            } else if (i == n - 1) {
                final int max = preMax[n - 2];
                if (nums[n - 1] > max) {
                    res++;
                }
            } else {
                final int min = suffMin[i + 1];
                final int max = preMax[i - 1];
                if (nums[i] < min && nums[i] > max) {
                    res++;
                }
            }
        }
        return res;
    }
}
