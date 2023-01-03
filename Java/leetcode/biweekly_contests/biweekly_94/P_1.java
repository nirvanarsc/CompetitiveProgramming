package leetcode.biweekly_contests.biweekly_94;

public class P_1 {

    public int captureForts(int[] forts) {
        final int n = forts.length;
        final int res = f(forts, n);
        reverse(forts, n);
        return Math.max(res, f(forts, n));
    }

    private static int f(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == 1 && arr[i + 1] == 0) {
                int j = i + 1;
                while (j < n && arr[j] == 0) {
                    j++;
                }
                if (j != n && arr[j] != 1) {
                    res = Math.max(res, j - i - 1);
                }
                i = j - 1;
            }
        }
        return res;
    }

    private static void reverse(int[] arr, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            final int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}
