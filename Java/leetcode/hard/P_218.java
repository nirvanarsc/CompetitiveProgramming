package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

public class P_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        final List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            final int[] b = buildings[i];
            pairs.add(new int[] { b[0], b[2], 1, i });
            pairs.add(new int[] { b[1], b[2], -1, i });
        }
        pairs.sort((a, b) -> {
            if (a[0] == b[0]) {
                // both start ? by decreasing height
                if (a[2] == 1 && b[2] == 1) {
                    return Integer.compare(b[1], a[1]);
                // both end ? by increasing height
                } else if (a[2] == -1 && b[2] == -1) {
                    return Integer.compare(a[1], b[1]);
                // else start before end
                } else {
                    return Integer.compare(b[2], a[2]);
                }
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        final TreeSet<Integer> height = new TreeSet<>((a, b) -> buildings[a][2] == buildings[b][2]
                                                                ? Integer.compare(a, b)
                                                                : Integer.compare(buildings[a][2],
                                                                                  buildings[b][2]));
        int max = 0;
        final List<List<Integer>> res = new ArrayList<>();
        for (int[] p : pairs) {
            if (p[2] == 1) {
                if (max < p[1]) {
                    max = p[1];
                    res.add(Arrays.asList(p[0], max));
                }
                height.add(p[3]);
            } else {
                height.remove(p[3]);
                final int currMax = height.isEmpty() ? 0 : buildings[height.last()][2];
                if (currMax < max) {
                    max = currMax;
                    res.add(Arrays.asList(p[0], max));
                }
            }
        }
        return res;
    }

    public List<List<Integer>> getSkylineDC(int[][] buildings) {
        if (buildings.length == 0) {
            return Collections.emptyList();
        }
        return new ArrayList<>(merge(buildings, 0, buildings.length - 1));
    }

    public Deque<List<Integer>> merge(int[][] num, int lo, int hi) {
        final Deque<List<Integer>> res = new ArrayDeque<>();
        if (lo == hi) {
            res.add(Arrays.asList(num[lo][0], num[lo][2]));
            res.add(Arrays.asList(num[lo][1], 0));
            return res;
        }
        final int mid = lo + hi >>> 1;
        final Deque<List<Integer>> left = merge(num, lo, mid);
        final Deque<List<Integer>> right = merge(num, mid + 1, hi);
        int leftH = 0;
        int rightH = 0;
        while (!left.isEmpty() && !right.isEmpty()) {
            final int x1 = left.peekFirst().get(0);
            final int x2 = right.peekFirst().get(0);
            final int x;
            if (x1 < x2) {
                final List<Integer> tmp = left.removeFirst();
                x = tmp.get(0);
                leftH = tmp.get(1);
            } else if (x1 > x2) {
                final List<Integer> tmp = right.removeFirst();
                x = tmp.get(0);
                rightH = tmp.get(1);
            } else {
                x = left.peekFirst().get(0);
                leftH = left.removeFirst().get(1);
                rightH = right.removeFirst().get(1);
            }
            final int h = Math.max(leftH, rightH);
            if (res.isEmpty() || h != res.peekLast().get(1)) {
                res.add(Arrays.asList(x, h));
            }
        }
        res.addAll(left);
        res.addAll(right);
        return res;
    }
}
