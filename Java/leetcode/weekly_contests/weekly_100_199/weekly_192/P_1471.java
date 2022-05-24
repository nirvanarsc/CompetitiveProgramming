package leetcode.weekly_contests.weekly_100_199.weekly_192;

import java.util.Arrays;

public class P_1471 {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        final int[] ans = new int[k];
        final int n = arr.length;
        int l = 0, r = n - 1;
        final int m = arr[(n + 1) / 2 - 1];
        for (int i = 0; i < k; i++) {
            if (Math.abs(m - arr[l]) > Math.abs(m - arr[r])) {
                ans[i] = arr[l];
                l++;
            } else {
                ans[i] = arr[r];
                r--;
            }
        }
        return ans;
    }
}
