package leetcode.weekly_contests.weekly_100_199.weekly_186;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P_1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        final Map<Integer, Deque<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                map.computeIfAbsent(i + j + 1, v -> new ArrayDeque<>()).addFirst(nums.get(i).get(j));
            }
        }
        return map.values().stream().flatMap(Collection::stream).mapToInt(Integer::intValue).toArray();
    }
}
