package leetcode.weekly_contests.weekly_220;

public class P_1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int j = 0;
        int curr = 0;
        int res = 0;
        final int[] f = new int[(int) (1e4 + 5)];
        for (int num : nums) {
            f[num]++;
            curr += num;
            while (f[num] > 1) {
                f[nums[j]]--;
                curr -= nums[j++];
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
