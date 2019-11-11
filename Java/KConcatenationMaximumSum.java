public final class KConcatenationMaximumSum {

    public static int kConcatenationMaxSum(int[] arr, int k) {
        final int mod = 1000000000 + 7;
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
            final int n = arr[i % arr.length];
            curr = Math.max(n, n + curr);
            res = Math.max(res, curr);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[] { 1, -2, 1 }, 5));
    }

    private KConcatenationMaximumSum() {}
}
