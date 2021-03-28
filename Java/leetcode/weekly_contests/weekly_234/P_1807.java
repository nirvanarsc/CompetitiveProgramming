package leetcode.weekly_contests.weekly_234;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        final Map<String, String> map = new HashMap<>();
        for (List<String> l : knowledge) {
            map.put(l.get(0), l.get(1));
        }
        final StringBuilder sb = new StringBuilder();
        final char[] w = s.toCharArray();
        for (int i = 0; i < w.length; i++) {
            if (w[i] != '(') {
                sb.append(w[i]);
            } else {
                int j = i + 1;
                final StringBuilder ww = new StringBuilder();
                while (j < w.length && w[j] != ')') {
                    ww.append(w[j]);
                    j++;
                }
                i = j;
                sb.append(map.getOrDefault(ww.toString(), "?"));
            }
        }
        return sb.toString();
    }
}
