package leetcode.biweekly_contests.biweekly_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class P_1182 {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        final Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        map.put(1, new TreeSet<>());
        map.put(2, new TreeSet<>());
        map.put(3, new TreeSet<>());
        for (int i = 0; i < colors.length; i++) {
            map.get(colors[i]).add(i);
        }
        final List<Integer> res = new ArrayList<>();
        for (int[] query : queries) {
            final TreeSet<Integer> integers = map.get(query[1]);
            final Integer left = integers.floor(query[0]);
            final Integer right = integers.ceiling(query[0]);
            if (left == null && right == null) {
                res.add(-1);
            } else if (left == null) {
                res.add(right - query[0]);
            } else if (right == null) {
                res.add(query[0] - left);
            } else {
                res.add(Math.min(query[0] - left, right - query[0]));
            }
        }
        return res;
    }
}
