package leetcode.weekly_contests.weekly_300_399.weekly_351;

public class P_1 {

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int countBeautifulPairs(int[] nums) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(f(nums[i]), nums[j] % 10) == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private static int f(int n) {
        if (n >= 1000) {
            return n / 1000;
        }
        if (n >= 100) {
            return n / 100;
        }
        if (n >= 10) {
            return n / 10;
        }
        return n;
    }
}
