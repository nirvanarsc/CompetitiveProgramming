package leetcode.weekly_contests.weekly_161;

public class P_1250 {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // https://en.wikipedia.org/wiki/B%C3%A9zout's_identity
    public boolean isGoodArray(int[] nums) {
        int gcd = nums[0];
        for (int num : nums) {
            if (gcd == 1) {
                return true;
            }
            gcd = gcd(gcd, num);
        }
        return gcd == 1;
    }
}
