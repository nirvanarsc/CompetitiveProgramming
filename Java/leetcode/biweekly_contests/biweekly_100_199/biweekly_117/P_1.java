package leetcode.biweekly_contests.biweekly_100_199.biweekly_117;

public class P_1 {

    public int distributeCandies(int n, int limit) {
        int res = 0;
        for (int i = 0; i <= Math.min(n, limit); i++) {
            res += f(n - i, limit);
        }
        return res;
    }

    private static int f(int n, int limit) {
        if (2 * limit < n) {
            return 0;
        }
        return Math.min(n, limit) - Math.max(n - limit, 0) + 1;
    }
}
