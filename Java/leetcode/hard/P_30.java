package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_30 {

    public List<Integer> findSubstring(String s, String[] words) {
        final List<Integer> res = new ArrayList<>();
        final Map<String, Integer> f = new HashMap<>();
        for (String str : words) {
            f.merge(str, 1, Integer::sum);
        }
        final int n = s.length();
        final int m = words.length;
        final int l = words[0].length();
        for (int start = 0; start < l; start++) {
            final Map<String, Integer> curr = new HashMap<>(f);
            int matched = m;
            int j = start;
            for (int i = start; i <= n - l; i += l) {
                if (curr.merge(s.substring(i, i + l), -1, Integer::sum) >= 0) {
                    matched--;
                }
                while (matched == 0) {
                    if (i - j + l == m * l) {
                        res.add(j);
                    }
                    if (curr.merge(s.substring(j, j + l), 1, Integer::sum) == 1) {
                        matched++;
                    }
                    j += l;
                }
            }
        }
        return res;
    }
}
