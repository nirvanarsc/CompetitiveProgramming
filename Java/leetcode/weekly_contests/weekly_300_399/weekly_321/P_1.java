package leetcode.weekly_contests.weekly_300_399.weekly_321;

public class P_1 {

    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if (f(i) == f(n) - f(i - 1)) {
                return i;
            }
        }
        return -1;
    }

    private static int f(int n) {
        return (n * (n + 1)) / 2;
    }
}
