package leetcode.weekly_contests.weekly_106;

import java.util.Arrays;

public class P_923 {

    private static final int MOD = (int) (1e9 + 7);

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        final int[] f = new int[105];
        final int n = arr.length;
        for (int num : arr) {
            f[num]++;
        }
        long res = 0;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                final int sum = arr[i] + arr[lo] + arr[hi];
                if (sum == target) {
                    if (arr[i] == arr[lo] && arr[i] == arr[hi]) {
                        res = (res + nC3(f[arr[i]])) % MOD;
                    } else if (arr[i] == arr[lo]) {
                        res = (res + nC2(f[arr[lo]]) * f[arr[hi]]) % MOD;
                    } else if (arr[lo] == arr[hi]) {
                        res = (res + nC2(f[arr[lo]]) * f[arr[i]]) % MOD;
                    } else {
                        res = (res + (long) f[arr[i]] * f[arr[lo]] * f[arr[hi]]) % MOD;
                    }
                    while (lo < hi && arr[lo + 1] == arr[lo]) { lo++; }
                    while (lo < hi && arr[hi - 1] == arr[hi]) { hi--; }
                    lo++;
                    hi--;
                } else if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return (int) res;
    }

    private static long nC3(long n) {
        return (n * (n - 1) * (n - 2)) / 6;
    }

    private static long nC2(long n) {
        return (n * (n - 1)) / 2;
    }
}
