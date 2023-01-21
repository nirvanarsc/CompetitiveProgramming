package leetcode.weekly_contests.weekly_300_399.weekly_328;

public class P_1 {

    public int differenceOfSum(int[] nums) {
        int l = 0;
        int r = 0;
        for (int num : nums) {
            l += num;
            r += f(num);
        }
        return Math.abs(l - r);
    }

    private static int f(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
