package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class P_139 {

    public boolean wordBreakBottomUp(String s, List<String> wordDict) {
        final Set<String> dict = new HashSet<>(wordDict);
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return recurse(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private static boolean recurse(String s, Set<String> dict, Map<String, Boolean> cache) {
        if (dict.contains(s)) {
            return true;
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i))) {
                if(recurse(s.substring(i), dict, cache)) {
                    cache.put(s, true);
                    return true;
                }
            }
        }

        cache.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    private P_139() {}
}
