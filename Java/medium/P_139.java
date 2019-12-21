package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class P_139 {

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

        boolean res = false;
        for (int i = 1; i < s.length(); i++) {
            if (dict.contains(s.substring(0, i))) {
                res |= recurse(s.substring(i), dict, cache);
            }
        }

        cache.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    private P_139() {}
}
