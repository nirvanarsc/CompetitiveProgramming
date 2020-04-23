package weekly_contests.weekly_45;

import java.util.HashMap;
import java.util.Map;

public class P_659 {

    public boolean isPossible(int[] nums) {
        final Map<Integer, Integer> freq = new HashMap<>();
        final Map<Integer, Integer> appendfreq = new HashMap<>();
        for (int i : nums) {
            freq.merge(i, 1, Integer::sum);
        }
        for (int i : nums) {
            if (freq.get(i) == 0) {
                continue;
            }
            if (appendfreq.getOrDefault(i, 0) > 0) {
                appendfreq.merge(i, -1, Integer::sum);
                appendfreq.merge(i + 1, 1, Integer::sum);
            } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.merge(i + 1, -1, Integer::sum);
                freq.merge(i + 2, -1, Integer::sum);
                appendfreq.merge(i + 3, 1, Integer::sum);
            } else {
                return false;
            }
            freq.merge(i, -1, Integer::sum);
        }
        return true;
    }
}
