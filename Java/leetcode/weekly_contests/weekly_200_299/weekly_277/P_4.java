package leetcode.weekly_contests.weekly_200_299.weekly_277;

public class P_4 {

    public int maximumGood(int[][] statements) {
        final int n = statements.length;
        int res = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int baddie = 0;
            int goodie = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < n; j++) {
                        if (statements[i][j] == 0) {
                            baddie |= 1 << j;
                        } else if (statements[i][j] == 1) {
                            goodie |= 1 << j;
                        }
                    }
                }
            }
            if ((mask & goodie) == goodie && (mask & baddie) == 0) {
                res = Math.max(res, Integer.bitCount(mask));
            }
        }
        return res;
    }
}
