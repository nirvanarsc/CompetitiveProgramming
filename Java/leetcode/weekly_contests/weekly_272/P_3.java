package leetcode.weekly_contests.weekly_272;

public class P_3 {

    public long getDescentPeriods(int[] prices) {
        long res = 0;
        final int n = prices.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < (n - 1) && prices[j] == 1 + prices[j + 1]) {
                j++;
            }
            final long L = j - i + 1;
            res += (L * (L + 1)) / 2;
            i = j;
        }
        return res;
    }
}
