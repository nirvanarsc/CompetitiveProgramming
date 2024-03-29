package leetcode.weekly_contests.weekly_200_299.weekly_214;

public class P_1646 {

    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        final int[] arr = new int[n + 1];
        arr[1] = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i / 2];
            } else {
                arr[i] = arr[i / 2] + arr[(i / 2) + 1];
            }
            res = Math.max(res, arr[i]);
        }
        return res;
    }
}
