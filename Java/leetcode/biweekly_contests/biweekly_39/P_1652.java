package leetcode.biweekly_contests.biweekly_39;

public class P_1652 {

    public int[] decrypt(int[] code, int k) {
        final int n = code.length;
        final int[] copy = new int[3 * code.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = code[i % n];
        }
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = f(copy, n + i, k);
        }
        return res;
    }

    private static int f(int[] arr, int idx, int k) {
        if (k == 0) {
            return 0;
        }
        if (k > 0) {
            int sum = 0;
            for (int j = idx + 1, i = 0; i < k; j++, i++) {
                sum += arr[j];
            }
            return sum;
        }
        k = -k;
        int sum = 0;
        for (int j = idx - k, i = 0; i < k; j++, i++) {
            sum += arr[j];
        }
        return sum;
    }
}
