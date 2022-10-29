package leetcode.biweekly_contests.biweekly_90;

import java.util.HashMap;
import java.util.Map;

public class P_1 {

    public String oddString(String[] words) {
        final Map<String, Integer> f = new HashMap<>();
        final Map<String, String> tt = new HashMap<>();
        for (String w : words) {
            final char[] t = w.toCharArray();
            final int n = t.length;
            final int d = t[0] - 'a';
            for (int i = 0; i < n; i++) {
                t[i] -= d;
            }
            f.merge(new String(t), 1, Integer::sum);
            tt.put(new String(t), w);
        }
        for (Map.Entry<String, Integer> entry : f.entrySet()) {
            if (entry.getValue() == 1) {
                return tt.get(entry.getKey());
            }
        }
        return "";
    }
}
