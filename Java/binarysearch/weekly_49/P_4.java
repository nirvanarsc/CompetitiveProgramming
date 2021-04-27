package binarysearch.weekly_49;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("SuspiciousNameCombination")
public class P_4 {

    public int[][] solve(int n, int[][] relations) {
        final Map<Integer, int[]> map = new HashMap<>();
        final Map<Integer, List<Integer>> left = new HashMap<>();
        final Map<Integer, List<Integer>> up = new HashMap<>();
        final Map<Integer, Integer> leftInDeg = new HashMap<>();
        final Map<Integer, Integer> upInDeg = new HashMap<>();
        for (int[] r : relations) {
            int x = r[0];
            int y = r[1];
            final int t = r[2];
            map.putIfAbsent(x, new int[] { -1, -1 });
            map.putIfAbsent(y, new int[] { -1, -1 });
            if (t <= 1) {
                if (t == 1) {
                    final int temp = x;
                    x = y;
                    y = temp;
                }
                left.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
                leftInDeg.merge(x, 1, Integer::sum);
                leftInDeg.merge(y, 0, Integer::sum);
            } else {
                if (t == 3) {
                    final int temp = x;
                    x = y;
                    y = temp;
                }
                up.computeIfAbsent(y, val -> new ArrayList<>()).add(x);
                upInDeg.merge(x, 1, Integer::sum);
                upInDeg.merge(y, 0, Integer::sum);
            }
        }
        topSort(map, up, upInDeg, n,0);
        topSort(map, left, leftInDeg, n,1);
        final int[][] res = new int[n][n];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }
        for (Map.Entry<Integer, int[]> e : map.entrySet()) {
            final int[] p = e.getValue();
            res[p[0]][p[1]] = e.getKey();
        }
        return res;
    }

    private static void topSort(Map<Integer, int[]> map, Map<Integer, List<Integer>> g,
                                Map<Integer, Integer> inDeg, int n, int idx) {
        final Deque<Integer> dq = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> e : inDeg.entrySet()) {
            if (e.getValue() == 0) {
                dq.offer(e.getKey());
            }
        }
        for (int i = n - 1; !dq.isEmpty(); i--) {
            for (int size = dq.size(); size > 0; size--) {
                final int curr = dq.removeFirst();
                map.get(curr)[idx] = i;
                for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                    if (inDeg.merge(next, -1, Integer::sum) == 0) {
                        dq.offerLast(next);
                    }
                }
            }
        }
    }
}
