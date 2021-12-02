package leetcode.biweekly_contests.biweekly_66;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1 {

    public int countWords(String[] words1, String[] words2) {
        final Map<String, Integer> f1 = new HashMap<>();
        final Map<String, Integer> f2 = new HashMap<>();
        final Set<String> all = new HashSet<>();
        for (String w : words1) {
            f1.merge(w, 1, Integer::sum);
            all.add(w);
        }
        for (String w : words2) {
            f2.merge(w, 1, Integer::sum);
            all.add(w);
        }
        int res = 0;
        for (String w : all) {
            if (f1.getOrDefault(w, 0) == 1 && f2.getOrDefault(w, 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
