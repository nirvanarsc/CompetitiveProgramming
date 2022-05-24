package leetcode.weekly_contests.weekly_200_299.weekly_206;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1583 {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        final Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.put(i, new HashMap<>());
            for (int j = 0; j < n - 1; j++) {
                g.get(i).put(preferences[i][j], j);
            }
        }
        final int[] friends = new int[n];
        for (int[] pair : pairs) {
            friends[pair[0]] = pair[1];
            friends[pair[1]] = pair[0];
        }
        final Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) { continue; }
                final int currU = g.get(i).get(friends[i]);
                final int currV = g.get(j).get(friends[j]);
                final int newU = g.get(i).get(j);
                final int newV = g.get(j).get(i);
                if (newU < currU && newV < currV) {
                    res.add(i);
                    res.add(j);
                }
            }
        }
        return res.size();
    }
}
