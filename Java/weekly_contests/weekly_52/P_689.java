package weekly_contests.weekly_52;

public class P_689 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] maxSumOfThreeSubarrays(int[] nums, int K) {
        final int[] W = new int[nums.length - K + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= K) {
                sum -= nums[i - K];
            }
            if (i >= K - 1) {
                W[i - K + 1] = sum;
            }
        }

        final int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) {
                best = i;
            }
            left[i] = best;
        }

        final int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) {
                best = i;
            }
            right[i] = best;
        }

        final int[] ans = { -1, -1, -1 };
        for (int j = K; j < W.length - K; j++) {
            final int i = left[j - K];
            final int k = right[j + K];
            if (ans[0] == -1 || W[i] + W[j] + W[k] > W[ans[0]] + W[ans[1]] + W[ans[2]]) {
                ans[0] = i;
                ans[1] = j;
                ans[2] = k;
            }
        }
        return ans;
    }
}
