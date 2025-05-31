package leetcode.weekly_contests.weekly_300_399.weekly_381;

public class P_2 {

    @SuppressWarnings({ "TailRecursion", "SuspiciousNameCombination" })
    public int[] countOfPairs(int n, int x, int y) {
        if (x > y) {
            return countOfPairs(n, y, x);
        }
        final int[] res = new int[n];
        for (int i = 1; i <= n; ++i) {
            res[0] += 2;                                             // go left and right
            res[Math.min(i - 1, Math.abs(i - y) + x)]--;             // reach 1 then stop
            res[Math.min(n - i, Math.abs(i - x) + 1 + n - y)]--;     // reach n then stop
            res[Math.min(Math.abs(i - x), Math.abs(y - i) + 1)]++;   // reach x then split
            res[Math.min(Math.abs(i - x) + 1, Math.abs(y - i))]++;   // reach y then split
            final int r = Math.max(x - i, 0) + Math.max(i - y, 0);
            res[r + (y - x) / 2]--;                                  // i -> x -> y <- x
            res[r + (y - x + 1) / 2]--;                              // i -> y -> x <- y
        }
        for (int i = 1; i < n; ++i) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
