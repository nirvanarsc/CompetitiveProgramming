package leetcode.weekly_contests.weekly_300_399.weekly_341;

public class P_2 {

    public int maxDivScore(int[] nums, int[] divisors) {
        final int[] res = { -1, -1 };
        for (int d : divisors) {
            int count = 0;
            for (int num : nums) {
                count += num % d == 0 ? 1 : 0;
            }
            if (res[1] < count) {
                res[0] = d;
                res[1] = count;
            } else if (res[1] == count && res[0] > d) {
                res[0] = d;
            }
        }
        return res[0];
    }
}
