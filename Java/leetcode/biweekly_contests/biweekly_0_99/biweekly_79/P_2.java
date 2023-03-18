package leetcode.biweekly_contests.biweekly_0_99.biweekly_79;

import java.util.HashMap;
import java.util.Map;

public class P_2 {

    public String largestWordCount(String[] messages, String[] senders) {
        final Map<String, Integer> map = new HashMap<>();
        final int n = messages.length;
        for (int i = 0; i < n; i++) {
            map.merge(senders[i], messages[i].split(" ").length, Integer::sum);
        }
        String best = "";
        int max = -1;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (max < e.getValue()) {
                best = e.getKey();
                max = e.getValue();
            } else if (max == e.getValue()) {
                if (best.compareTo(e.getKey()) < 0) {
                    best = e.getKey();
                }
            }
        }
        return best;
    }
}
