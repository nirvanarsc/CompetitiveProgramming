package weekly_contests.weekly_187;

public class P_1437 {

    public boolean kLengthApart(int[] nums, int k) {
        int j = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 2) {
                while (sum == 2) {
                    sum -= nums[j++];
                }
                res = Math.min(res, i - j);
            }
        }
        return res >= k;
    }
}
