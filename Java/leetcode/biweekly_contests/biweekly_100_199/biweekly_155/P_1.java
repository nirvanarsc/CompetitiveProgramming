package leetcode.biweekly_contests.biweekly_100_199.biweekly_155;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class P_1 {

    public String findCommonResponse(List<List<String>> responses) {
        final Map<String, Integer> f = new HashMap<>();
        for (List<String> r : responses) {
            for (String s : new HashSet<>(r)) {
                f.merge(s, 1, Integer::sum);
            }
        }
        String res = "";
        int max = -1;
        for (Map.Entry<String, Integer> e : f.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                res = e.getKey();
            } else if (e.getValue() == max && res.compareTo(e.getKey()) > 0) {
                res = e.getKey();
            }
        }
        return res;
    }
}
