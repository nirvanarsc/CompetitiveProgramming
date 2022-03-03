package leetcode.medium;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_413 {

    public int numberOfArithmeticSlicesDP(int[] A) {
        final int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        final int n = nums.length;
        final int[] arr = new int[n - 1];
        for (int i = 0; i < (n - 1); i++) {
            arr[i] = nums[i + 1] - nums[i];
        }
        int res = 0;
        for (int i = 0; i < (n - 1); i++) {
            int j = i;
            while (j < (n - 1) && arr[j] == arr[i]) {
                j++;
            }
            final int l = j - i;
            res += (l * (l - 1)) / 2;
            i = j - 1;
        }
        return res;
    }
}
