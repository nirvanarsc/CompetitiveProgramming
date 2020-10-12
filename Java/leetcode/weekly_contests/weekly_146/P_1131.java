package leetcode.weekly_contests.weekly_146;

public class P_1131 {

    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        final int n = arr1.length;
        int ans = 0;
        int maxmm = Integer.MIN_VALUE;
        int maxmp = Integer.MIN_VALUE;
        int maxpm = Integer.MIN_VALUE;
        int maxpp = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxmm = Math.max(maxmm, -arr1[i] - arr2[i] - i);
            maxmp = Math.max(maxmp, -arr1[i] + arr2[i] - i);
            maxpm = Math.max(maxpm, arr1[i] - arr2[i] - i);
            maxpp = Math.max(maxpp, arr1[i] + arr2[i] - i);
            ans = Math.max(ans, maxmm + arr1[i] + arr2[i] + i);
            ans = Math.max(ans, maxmp + arr1[i] - arr2[i] + i);
            ans = Math.max(ans, maxpm - arr1[i] + arr2[i] + i);
            ans = Math.max(ans, maxpp - arr1[i] - arr2[i] + i);
        }
        return ans;
    }
}
