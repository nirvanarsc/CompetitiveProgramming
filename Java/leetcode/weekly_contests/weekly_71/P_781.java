package leetcode.weekly_contests.weekly_71;

import java.util.HashMap;
import java.util.Map;

public class P_781 {

    public int numRabbits(int[] answers) {
        final Map<Integer, Integer> m = new HashMap<>();
        for (int ans : answers) {
            m.merge(ans, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            final Integer val = entry.getValue();
            final Integer key = entry.getKey();
            res += ((val + key) / (key + 1)) * (key + 1);
        }
        return res;
    }
}
