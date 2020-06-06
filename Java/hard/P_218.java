package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.TreeMap;

public class P_218 {

    static class Point {
        int start;
        int height;
        boolean isStart;

        Point(int start, int height, boolean isStart) {
            this.start = start;
            this.height = height;
            this.isStart = isStart;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        final TreeMap<Integer, Integer> activeHeights = new TreeMap<>(Collections.singletonMap(0, 1));
        final List<List<Integer>> res = new ArrayList<>();
        final List<Point> lineSweep = new ArrayList<>();
        for (int[] b : buildings) {
            lineSweep.add(new Point(b[0], b[2], true));
            lineSweep.add(new Point(b[1], b[2], false));
        }
        lineSweep.sort((a, b) -> {
            if (a.start == b.start) {
                if (a.isStart && b.isStart) {
                    return Integer.compare(b.height, a.height);
                } else if (!a.isStart && !b.isStart) {
                    return Integer.compare(a.height, b.height);
                } else {
                    return Boolean.compare(b.isStart, a.isStart);
                }
            }
            return Integer.compare(a.start, b.start);
        });
        int currHeight = 0;
        for (Point p : lineSweep) {
            if (p.isStart) {
                activeHeights.merge(p.height, 1, Integer::sum);
            } else {
                activeHeights.merge(p.height, -1, Integer::sum);
                if (activeHeights.get(p.height) == 0) {
                    activeHeights.remove(p.height);
                }
            }
            if (currHeight != activeHeights.lastKey()) {
                currHeight = activeHeights.lastKey();
                res.add(Arrays.asList(p.start, currHeight));
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
