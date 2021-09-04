package leetcode.biweekly_contests.biweekly_60;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public int[][] findFarmland(int[][] land) {
        final List<int[]> res = new ArrayList<>();
        final int n = land.length;
        final int m = land[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    int k = i;
                    while (k < n && land[k][j] == 1) {
                        k++;
                    }
                    int l = j;
                    while (l < m && land[i][l] == 1) {
                        l++;
                    }
                    res.add(new int[] { i, j, k - 1, l - 1 });
                    for (int o = i; o < k; o++) {
                        for (int p = j; p < l; p++) {
                            land[o][p] = 0;
                        }
                    }
                }
            }
        }
        return res.toArray(int[][]::new);
    }
}
