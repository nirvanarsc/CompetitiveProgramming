package leetcode.biweekly_contests.biweekly_0_99.biweekly_31;

public class P_1523 {

    public int countOdds(int low, int high) {
        return f(high) - f(low - 1);
    }

    private static int f(int n) {
        return (n + 1) / 2;
    }
}
