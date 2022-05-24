package leetcode.weekly_contests.weekly_100_199.weekly_161;

public class P_1250 {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean isGoodArray(int[] nums) {
        int gcd = 0;
        for (int num : nums) {
            gcd = gcd(gcd, num);
        }
        return gcd == 1;
    }
}
