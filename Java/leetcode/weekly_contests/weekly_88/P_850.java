package leetcode.weekly_contests.weekly_88;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_850 {

    static class Point {
        int x, y, val;

        Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    public int rectangleArea(int[][] rectangles) {
        final List<Point> data = new ArrayList<>();
        for (int[] r : rectangles) {
            data.add(new Point(r[0], r[1], 1));
            data.add(new Point(r[0], r[3], -1));
            data.add(new Point(r[2], r[1], -1));
            data.add(new Point(r[2], r[3], 1));
        }
        data.sort((a, b) -> a.x == b.x ? Integer.compare(b.y, a.y) : Integer.compare(a.x, b.x));
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        int preX = -1, preY = -1, result = 0;
        for (int i = 0; i < data.size(); i++) {
            final Point p = data.get(i);
            map.merge(p.y, p.val, Integer::sum);
            if (i == data.size() - 1 || data.get(i + 1).x > p.x) {
                if (preX > -1) {
                    result += ((long) preY * (p.x - preX)) % MOD;
                    result %= MOD;
                }
                preY = calcY(map);
                preX = p.x;
            }
        }
        return result;
    }

    private static int calcY(TreeMap<Integer, Integer> map) {
        int result = 0, pre = -1, count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (pre >= 0 && count > 0) {
                result += e.getKey() - pre;
            }
            count += e.getValue();
            pre = e.getKey();
        }
        return result;
    }
}
