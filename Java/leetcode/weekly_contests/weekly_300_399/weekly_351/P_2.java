package leetcode.weekly_contests.weekly_300_399.weekly_351;

public class P_2 {

    public int makeTheIntegerZero(int num1, int num2) {
        for (int i = 0; i < 61; i++) {
            final long target = num1 - (long) i * num2;
            if (0 <= target && Long.bitCount(target) <= i && i <= target) {
                return i;
            }
        }
        return -1;
    }
}
