package leetcode.weekly_contests.weekly_171;

public class P_1317 {

    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - 1;
        while (!hasNoZeroes(a) || !hasNoZeroes(b)) {
            a++;
            b--;
        }
        return new int[] { a, b };
    }

    private static boolean hasNoZeroes(int n) {
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
