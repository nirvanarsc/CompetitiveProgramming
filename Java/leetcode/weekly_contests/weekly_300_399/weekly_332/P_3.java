package leetcode.weekly_contests.weekly_300_399.weekly_332;

import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public int[][] substringXorQueries(String s, int[][] queries) {
        final int q = queries.length;
        final int[][] res = new int[q][2];
        final Map<String, Integer> map = new HashMap<>();
        for (int l = 1; l <= 32; l++) {
            for (int i = 0; i <= s.length() - l; i++) {
                map.putIfAbsent(s.substring(i, i + l), i);
            }
        }
        for (int i = 0; i < q; i++) {
            final String u = Integer.toBinaryString(queries[i][0] ^ queries[i][1]);
            final int idx = map.getOrDefault(u, -1);
            if (idx == -1) {
                res[i] = new int[] { -1, -1 };
            } else {
                res[i] = new int[] { idx, idx + u.length() - 1 };
            }
        }
        return res;
    }
}
