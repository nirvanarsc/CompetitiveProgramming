package leetcode.weekly_contests.weekly_0_99.weekly_27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_554 {

    public int leastBricks(List<List<Integer>> wall) {
        final Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (int i = 0; i < wall.size(); i++) {
            final List<Integer> row = wall.get(i);
            int pre = 0;
            for (int j = 0; j < row.size() - 1; j++) {
                pre += row.get(j);
                max = Math.max(max, freq.merge(pre, 1, Integer::sum));
            }
        }
        return wall.size() - max;
    }
}
