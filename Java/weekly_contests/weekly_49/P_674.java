package weekly_contests.weekly_49;

public class P_674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 1;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                curr++;
            } else {
                curr = 1;
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
