import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        final Set<String> dict = new HashSet<>();
        int maxLen = 0;
        for (String w : wordDict) {
            dict.add(w);
            maxLen = Math.max(maxLen, w.length());
        }
        return recurse(0, maxLen, s, dict, new HashMap<>());
    }

    private static List<String> recurse(int start,
                                        int maxLength,
                                        String s,
                                        Set<String> dict,
                                        Map<Integer, List<String>> dp) {
        if (dp.containsKey(start)) {
            return dp.get(start);
        }
        final List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int i = start; i < start + maxLength && i < s.length(); i++) {
            if (dict.contains(s.substring(start, i + 1))) {
                final List<String> recurse = recurse(i + 1, maxLength, s, dict, dp);
                for (String sub : recurse) {
                    res.add(s.substring(start, i + 1) + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        dp.put(start, res);
        return dp.get(start);
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(wordBreak("pineapplepenapple",
                                     Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    private WordBreakII() {}
}
