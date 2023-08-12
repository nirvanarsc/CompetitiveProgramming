package leetcode.biweekly_contests.biweekly_100_199.biweekly_108;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_2 {

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        final Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.merge(num, 1, Integer::sum);
        }
        final int q = moveFrom.length;
        for (int i = 0; i < q; i++) {
            final int u = moveFrom[i];
            final int v = moveTo[i];
            f.merge(v, f.remove(u), Integer::sum);
        }
        return f.keySet().stream().sorted().collect(Collectors.toList());
    }
}
