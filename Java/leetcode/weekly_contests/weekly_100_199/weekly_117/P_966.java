package leetcode.weekly_contests.weekly_100_199.weekly_117;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_966 {

    private Set<String> exact;
    private Map<String, String> lower;
    private Map<String, String> devowel;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        exact = new HashSet<>();
        lower = new HashMap<>();
        devowel = new HashMap<>();
        for (String word : wordlist) {
            exact.add(word);
            final String wordLow = word.toLowerCase();
            lower.putIfAbsent(wordLow, word);
            final String wordLowDV = devowel(wordLow);
            devowel.putIfAbsent(wordLowDV, word);
        }
        final String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = solve(queries[i]);
        }
        return res;
    }

    public String solve(String query) {
        if (exact.contains(query)) {
            return query;
        }
        final String queryL = query.toLowerCase();
        if (lower.containsKey(queryL)) {
            return lower.get(queryL);
        }
        final String queryLV = devowel(queryL);
        if (devowel.containsKey(queryLV)) {
            return devowel.get(queryLV);
        }
        return "";
    }

    public String devowel(String word) {
        final StringBuilder ans = new StringBuilder();
        for (char c : word.toCharArray()) {
            ans.append(isVowel(c) ? '*' : c);
        }
        return ans.toString();
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
