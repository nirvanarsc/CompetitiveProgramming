package leetcode.weekly_contests.weekly_100_199.weekly_169;

public class P_1304 {

    public int[] sumZero(int n) {
        final int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < (n - 1); i++) {
            res[i] = i + 1;
            sum += i + 1;
        }
        res[n - 1] = -sum;
        return res;
    }
}
