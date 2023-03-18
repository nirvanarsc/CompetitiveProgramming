package leetcode.biweekly_contests.biweekly_0_99.biweekly_24;

public class P_1413 {

    public int minStartValue(int[] nums) {
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            res = Math.min(res, sum);
        }
        return -res + 1;
    }
}
