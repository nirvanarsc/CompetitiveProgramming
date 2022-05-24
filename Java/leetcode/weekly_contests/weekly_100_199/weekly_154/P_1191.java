package leetcode.weekly_contests.weekly_100_199.weekly_154;

public class P_1191 {

    public int kConcatenationMaxSum(int[] arr, int k) {
        final int mod = (int) (1e9 + 7);
        if (k == 1) { return kadane(arr, 1); }
        long sum = 0;
        for (int n : arr) { sum += n; }
        if (k == 2 || sum <= 0) { return kadane(arr, 2); }
        return (int) (((k - 2) * (sum % mod) + kadane(arr, 2)) % mod);
    }

    private static int kadane(int[] arr, int k) {
        int curr = 0;
        int res = 0;
        for (int i = 0; i < k * arr.length; i++) {
            curr = Math.max(arr[i % arr.length], arr[i % arr.length] + curr);
            res = Math.max(res, curr);
        }
        return res;
    }
}
