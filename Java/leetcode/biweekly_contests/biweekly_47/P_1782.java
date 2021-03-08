package leetcode.biweekly_contests.biweekly_47;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1782 {

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        final int[] deg = new int[n];
        final Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] ed : edges) {
            int u = ed[0] - 1;
            int v = ed[1] - 1;
            deg[u]++;
            deg[v]++;
            if (u > v) {
                final int temp = u;
                u = v;
                v = temp;
            }
            // store the number of edges for each node pair
            cnt.merge(u * 20000 + v, 1, Integer::sum);
        }
        final int[] sorted = deg.clone();
        Arrays.sort(sorted);
        final int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int curr = 0;
            int l = 0;
            int r = sorted.length - 1;
            while (l < r) {
                if (sorted[l] + sorted[r] > queries[i]) {
                    curr += r - l;
                    r--;
                } else {
                    l++;
                }
            }
            // remove all invalid pairs
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                final int k = entry.getKey();
                final int u = k / 20000;
                final int v = k % 20000;
                if (deg[u] + deg[v] > queries[i] && deg[u] + deg[v] - entry.getValue() <= queries[i]) {
                    curr--;
                }
            }
            res[i] = curr;
        }
        return res;
    }
}
