package leetcode.biweekly_contests.biweekly_0_99.biweekly_99;

public class P_2 {

    public long coloredCells(int n) {
        return 1 + f(n) * 4;
    }

    private static long f(long n) {
        return (n * (n - 1)) / 2;
    }
}
