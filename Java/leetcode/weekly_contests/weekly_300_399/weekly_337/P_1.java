package leetcode.weekly_contests.weekly_300_399.weekly_337;

public class P_1 {

    public int[] evenOddBit(int n) {
        final int[] res = new int[2];
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res[i % 2]++;
            }
        }
        return res;
    }
}
