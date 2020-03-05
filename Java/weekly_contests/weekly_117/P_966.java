package weekly_contests.weekly_117;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_966 {

    @SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
    public String[] spellchecker(String[] wordlist, String[] queries) {
        final Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        final Map<String, String> cap = new HashMap<>();
        final Map<String, String> vowel = new HashMap<>();
        for (String w : wordlist) {
            final String lower = w.toLowerCase();
            final String devowel = lower.replaceAll("[aeiou]", "#");
            cap.putIfAbsent(lower, w);
            vowel.putIfAbsent(devowel, w);
        }
        for (int i = 0; i < queries.length; ++i) {
            if (!words.contains(queries[i])) {
                final String lower = queries[i].toLowerCase();
                final String devowel = lower.replaceAll("[aeiou]", "#");
                if (cap.containsKey(lower)) {
                    queries[i] = cap.get(lower);
                } else {
                    queries[i] = vowel.getOrDefault(devowel, "");
                }
            }
        }
        return queries;
    }
}
