package leetcode.weekly_contests.weekly_200_299.weekly_279;

public class P_4 {

    public int minimumTime(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[] arr = new int[n + 1];
        arr[0] = n;
        int curr = 0;
        for (int i = 1; i <= n; i++) {
            curr += w[i - 1] == '1' ? 2 : 0;
            arr[i] = curr + (n - i);
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Math.min(arr[i], arr[i + 1]);
        }
        int res = arr[0];
        curr = 0;
        for (int i = 1; i <= n; i++) {
            curr += w[i - 1] == '1' ? 2 : 0;
            res = Math.min(res, arr[i] - curr + i);
        }
        return res;
    }
}
