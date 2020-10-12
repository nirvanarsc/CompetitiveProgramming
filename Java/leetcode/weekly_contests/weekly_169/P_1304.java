package leetcode.weekly_contests.weekly_169;

public class P_1304 {

    public int[] sumZero(int n) {
        final int[] res = new int[n];
        int k = 0;
        for (int i = -1 * (n / 2); i <= n / 2; i++) {
            if (n % 2 == 0 && i == 0) {
                continue;
            }
            res[k++] = i;
        }
        return res;
    }
}
