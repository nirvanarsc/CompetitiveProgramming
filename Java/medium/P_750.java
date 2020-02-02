package medium;

import java.util.HashMap;
import java.util.Map;

public class P_750 {

    public int countCornerRectanglesDP(int[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int[][] dp = new int[n][m];
        int res = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    for (int q = j + 1; q < m; q++) {
                        if (ints[q] == 1) {
                            res += dp[j][q]++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int counter = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        counter++;
                    }
                }
                ans += counter * (counter - 1) / 2;
            }
        }
        return ans;
    }

    public int countCornerRectanglesMap(int[][] grid) {
        final int m = grid[0].length;
        final Map<String, Integer> map = new HashMap<>();
        int total = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                if (ints[j] == 1) {
                    for (int k = j + 1; k < m; k++) {
                        if (ints[k] == 1) {
                            final String key = j + "," + k;
                            map.merge(key, 1, Integer::sum);
                        }
                    }
                }
            }
        }
        for (Integer integer : map.values()) {
            total += integer * (integer - 1) / 2;
        }
        return total;
    }
}
