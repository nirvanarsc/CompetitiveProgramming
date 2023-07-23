package leetcode.biweekly_contests.biweekly_100_199.biweekly_103;

public class P_1 {

    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += max++;
        }
        return res;
    }
}
