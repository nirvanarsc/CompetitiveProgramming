package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_281 {

    public static class ZigzagIterator {
        Deque<int[]> indices = new ArrayDeque<>();
        Map<Integer, List<Integer>> map;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            map = new HashMap<>();
            if (!v1.isEmpty()) {
                map.put(0, v1);
                indices.offerLast(new int[] { 0, 0 });
            }
            if (!v2.isEmpty()) {
                map.put(1, v2);
                indices.offerLast(new int[] { 0, 1 });
            }
        }

        public int next() {
            final int[] ints = indices.removeFirst();
            final int res = map.get(ints[1]).get(ints[0]);
            if (ints[0] + 1 < map.get(ints[1]).size()) {
                indices.offerLast(new int[] { ints[0] + 1, ints[1] });
            }
            return res;
        }

        public boolean hasNext() {
            return !indices.isEmpty();
        }
    }
}
