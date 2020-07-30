package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class P_140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        final Set<String> dict = new HashSet<>();
        int maxLen = 0;
        for (String w : wordDict) {
            dict.add(w);
            maxLen = Math.max(maxLen, w.length());
        }
        return dfs(0, maxLen, s, dict, new HashMap<>());
    }

    private static List<String> dfs(int start, int max, String s, Set<String> dict,
                                    Map<Integer, List<String>> dp) {
        if (start == s.length()) {
            return Collections.singletonList("");
        }
        if (dp.containsKey(start)) {
            return dp.get(start);
        }
        final List<String> res = new ArrayList<>();
        for (int end = start + 1; end <= start + max && end <= s.length(); end++) {
            final String curr = s.substring(start, end);
            if (dict.contains(curr)) {
                for (String sub : dfs(end, max, s, dict, dp)) {
                    res.add(curr + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        dp.put(start, res);
        return res;
    }
}
