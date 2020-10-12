package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_370 {

    static class Point {
        int p;
        int cost;
        boolean isStart;

        Point(int p, int cost, boolean isStart) {
            this.p = p;
            this.cost = cost;
            this.isStart = isStart;
        }
    }

    public int[] getModifiedArrayLineSweep(int length, int[][] updates) {
        final List<Point> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new Point(i, 0, true));
        }
        for (int[] u : updates) {
            list.add(new Point(u[0], u[2], true));
            list.add(new Point(u[1] + 1, -u[2], false));
        }
        list.sort((a, b) -> a.p == b.p ? Boolean.compare(b.isStart, a.isStart) : Integer.compare(a.p, b.p));
        final int[] res = new int[length + 1];
        int val = 0;
        for (Point p : list) {
            val += p.cost;
            res[p.p] = val;
        }
        return Arrays.copyOf(res, length);
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        final int[] res = new int[length];
        for (int[] update : updates) {
            res[update[0]] += update[2];
            if (update[1] + 1 < length) {
                res[update[1] + 1] -= update[2];
            }
        }
        for (int i = 0; i < length - 1; i++) {
            res[i + 1] += res[i];
        }
        return res;
    }
}
