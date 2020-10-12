package leetcode.weekly_contests.weekly_202;

public class P_1551 {

    public int minOperations(int n) {
        int diff = 0;
        for (int i = 1; i <= n; i++) {
            diff += Math.abs(i - n);
        }
        return diff;
    }
}
