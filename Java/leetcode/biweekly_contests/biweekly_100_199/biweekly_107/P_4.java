package leetcode.biweekly_contests.biweekly_100_199.biweekly_107;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P_4 {

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        final int m = logs.length;
        final int q = queries.length;
        final int[][] sorted = new int[q][2];
        for (int i = 0; i < q; i++) {
            sorted[i] = new int[] { queries[i], i };
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        final Map<Integer, Integer> g = new HashMap<>();
        int j = 0;
        int k = 0;
        final int[] res = new int[q];
        for (int i = 0; i < m; i++) {
            g.merge(logs[i][0], 1, Integer::sum);
            while (k < q && (i == m - 1 || logs[i][1] > sorted[k][0])) {
                while (j < m && sorted[k][0] - x > logs[j][1]) {
                    if (g.merge(logs[j][0], -1, Integer::sum) == 0) {
                        g.remove(logs[j][0]);
                    }
                    j++;
                }
                final int curr = logs[i][1] > sorted[k][0] && g.get(logs[i][0]) == 1 ? 1 : 0;
                res[sorted[k++][1]] = n - g.size() + curr;
            }
        }
        return res;
    }
}
