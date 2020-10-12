package leetcode.medium;

public class P_357 {

    public int countNumbersWithUniqueDigits(int n) {
        final long max = (long) Math.pow(10, Math.min(n, 10));
        return dfs(0, max, new boolean[10], true);
    }

    private static int dfs(long curr, long max, boolean[] used, boolean first) {
        if (curr >= max) {
            return 0;
        }
        int count = 1;
        for (int i = first ? 1 : 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                count += dfs(10 * curr + i, max, used, false);
                used[i] = false;
            }
        }
        return count;
    }

    // f(1) = 10 (0, 1, 2, 3, ...., 9)
    // f(2) = 9 * 9
    // f(3) = f(2) * 8 = 9 * 9 * 8
    // f(4) = f(3) * 7 = 9 * 9 * 8 * 7
    // ...
    // f(10) = 9 * 9 * 8 * 7 * 6 * ... * 1
    // f(11) = 0 = f(12) = f(13)....
    public int countNumbersWithUniqueDigitsDP(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits *= availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
