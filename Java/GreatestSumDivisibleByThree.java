import java.util.Arrays;

public final class GreatestSumDivisibleByThree {

    public static int maxSumDivK(int[] nums, int k) {
        int[] dp = new int[k];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int num : nums) {
            final int[] curr = new int[k];
            for (int i = 0; i < k; i++) {
                curr[(i + num) % k] = Math.max(dp[(i + num) % k], dp[i] + num);
            }
            dp = curr;
        }

        return dp[0];
    }

    public static int maxSumDivThree(int[] nums) {
        return maxSumDivK(nums, 3);
    }

    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[] { 3, 6, 5, 1, 8 }));
    }

    private GreatestSumDivisibleByThree() {}
}
