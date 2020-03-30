package weekly_contests.weekly_75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import utils.DataStructures.UnionFind;

public class P_799 {

    public double champagneTower(int poured, int query_row, int query_glass) {
        final double[] dp = new double[101];
        dp[0] = poured;
        for (int row = 1; row <= query_row; row++) {
            for (int i = row; i >= 0; i--) {
                dp[i + 1] += dp[i] = Math.max(0.0, (dp[i] - 1) / 2);
            }
        }
        return Math.min(dp[query_glass], 1.0);
    }
}
