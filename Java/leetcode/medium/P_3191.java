package leetcode.medium;

public class P_3191 {

    public int minOperations(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i > n - 3) {
                    return -1;
                }
                for (int j = 0; j < 3; j++) {
                    nums[i + j] ^= 1;
                }
                res++;
            }
        }
        return res;
    }
}
