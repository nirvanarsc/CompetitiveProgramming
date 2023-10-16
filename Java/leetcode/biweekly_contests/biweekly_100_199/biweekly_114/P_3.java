package leetcode.biweekly_contests.biweekly_100_199.biweekly_114;

public class P_3 {

    public int maxSubarrays(int[] nums) {
        int curr = -1;
        int res = 0;
        for (int num : nums) {
            if (curr == -1) {
                curr = num;
            } else {
                curr &= num;
            }
            if (curr == 0) {
                res++;
                curr = -1;
            }
        }
        if (curr > 0) {
            return res > 0 ? res : 1;
        }
        return res;
    }
}
