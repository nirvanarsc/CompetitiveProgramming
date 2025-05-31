package leetcode.weekly_contests.weekly_300_399.weekly_382;

public class P_3 {

    public long flowerGame(int n, int m) {
        final long oddX = (n + 1) / 2;
        final long evenX = n - oddX;

        final long oddY = (m + 1) / 2;
        final long evenY = m - oddY;

        return oddX * evenY + evenX * oddY;
    }
}
