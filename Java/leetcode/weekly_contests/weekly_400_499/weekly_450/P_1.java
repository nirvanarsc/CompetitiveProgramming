package leetcode.weekly_contests.weekly_400_499.weekly_450;

public class P_1 {

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (f(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    private static int f(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
