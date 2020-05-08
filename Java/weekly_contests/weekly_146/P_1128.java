package weekly_contests.weekly_146;

import java.util.HashMap;
import java.util.Map;

public class P_1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
        final Map<String, Integer> freq = new HashMap<>();
        for (int[] d : dominoes) {
            final String key = d[0] > d[1] ? d[1] + "," + d[0] : d[0] + "," + d[1];
            freq.merge(key, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() > 1) {
                res += (e.getValue() * (e.getValue() - 1)) / 2;
            }
        }
        return res;
    }
}
