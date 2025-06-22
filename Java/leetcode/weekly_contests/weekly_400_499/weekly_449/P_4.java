package leetcode.weekly_contests.weekly_400_499.weekly_449;

public class P_4 {

    public long maxScore(int n, int[][] edges) {
        long res = 0;
        for (int i = 3; i <= n; i += 2) {
            res += (long) i * (i - 2);
        }
        for (int i = 4; i <= n; i += 2) {
            res += (long) i * (i - 2);
        }
        res += (long) n * (n - 1);
        return edges.length == n ? res + 2 : res;
    }
}
