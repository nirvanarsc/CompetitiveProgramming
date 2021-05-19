package binarysearch.weekly_44;

public class P_3 {

    public int solve(int[] nums) {
        final int n = nums.length;
        if (n < 2) {
            return n;
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (max - min + 1 == j - i + 1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
