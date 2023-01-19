package leetcode.weekly_contests.weekly_100_199.weekly_119;

public class P_974 {

    public int subarraysDivByK(int[] nums, int k) {
        final int[] f = new int[k];
        f[0] = 1;
        int res = 0, sum = 0;
        for (int num : nums) {
            sum = (sum + num) % k;
            sum = (sum + k) % k;
            res += f[sum]++;
        }
        return res;
    }
}
