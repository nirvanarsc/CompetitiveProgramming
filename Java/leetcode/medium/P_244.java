package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class P_244 {

    static class WordDistance {

        Map<String, List<Integer>> indexes;

        WordDistance(String[] words) {
            indexes = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                indexes.computeIfAbsent(words[i], v -> new ArrayList<>()).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            final List<Integer> loc1 = indexes.get(word1);
            final List<Integer> loc2 = indexes.get(word2);
            int l1 = 0, l2 = 0, res = Integer.MAX_VALUE;
            while (l1 < loc1.size() && l2 < loc2.size()) {
                res = Math.min(res, Math.abs(loc1.get(l1) - loc2.get(l2)));
                if (loc1.get(l1) < loc2.get(l2)) {
                    l1++;
                } else {
                    l2++;
                }
            }
            return res;
        }
    }
}
