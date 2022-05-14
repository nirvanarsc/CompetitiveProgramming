package leetcode.biweekly_contests.biweekly_78;

public class P_2 {

    public int waysToSplitArray(int[] nums) {
        long s = 0;
        for (int num : nums) {
            s += num;
        }
        long curr = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curr += nums[i];
            s -= nums[i];
            if (curr >= s) {
                res++;
            }
        }
        return res;
    }
}
