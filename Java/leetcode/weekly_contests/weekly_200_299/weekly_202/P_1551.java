package leetcode.weekly_contests.weekly_200_299.weekly_202;

public class P_1551 {

    public int minOperations(int n) {
        final int len = n / 2;
        return (n - len) * len;
    }
}
