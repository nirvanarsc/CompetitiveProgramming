package leetcode.weekly_contests.weekly_300_399.weekly_366;

public class P_1 {

    public int differenceOfSums(int n, int m) {
        return f(n) - 2 * m * f(n / m);
    }

    private static int f(int n) {
        return (n * (n + 1)) / 2;
    }
}
