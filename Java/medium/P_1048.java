package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_1048 {

    public int longestStrChainBottomUp(String[] words) {
        final Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                final String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }

    public int longestStrChain(String[] words) {
        final Map<String, Integer> map = new HashMap<>();
        final Set<String> set = new HashSet<>(Arrays.asList(words));
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, helper(map, set, word));
        }
        return ans;
    }

    private static int helper(Map<String, Integer> map, Set<String> set, String word) {
        if (map.containsKey(word)) {
            return map.get(word);
        }
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            final String next = word.substring(0, i) + word.substring(i + 1);
            if (set.contains(next)) {
                cnt = Math.max(cnt, helper(map, set, next));
            }
        }
        map.put(word, 1 + cnt);
        return 1 + cnt;
    }
}
