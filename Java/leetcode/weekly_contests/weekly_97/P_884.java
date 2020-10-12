package leetcode.weekly_contests.weekly_97;

import java.util.HashMap;
import java.util.Map;

public class P_884 {

    @SuppressWarnings({ "MethodParameterNamingConvention", "DynamicRegexReplaceableByCompiledPattern" })
    public String[] uncommonFromSentences(String A, String B) {
        final Map<String, Integer> map = new HashMap<>();
        for (String s : (A + ' ' + B).split("\\s")) {
            map.merge(s, 1, Integer::sum);
        }
        return map.keySet()
                  .stream()
                  .filter(y -> map.get(y) == 1)
                  .toArray(String[]::new);
    }
}
