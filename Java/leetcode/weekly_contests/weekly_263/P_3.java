package leetcode.weekly_contests.weekly_263;

public class P_3 {

    public int countMaxOrSubsets(int[] nums) {
        final int n = nums.length;
        int max = 0;
        int res = 0;
        for (int num : nums) {
            max |= num;
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            int curr = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    curr |= nums[i];
                }
            }
            if (curr == max) {
                res++;
            }
        }
        return res;
    }
}
