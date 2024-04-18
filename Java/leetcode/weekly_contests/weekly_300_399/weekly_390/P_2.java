package leetcode.weekly_contests.weekly_300_399.weekly_390;

public class P_2 {

    public int minOperations(int k) {
        int res = (int) 1e9;
        for (int d = 1; d <= k; d++) {
            res = Math.min(res, d - 1 + ((k - 1) / d));
        }
        return res;
    }
}
