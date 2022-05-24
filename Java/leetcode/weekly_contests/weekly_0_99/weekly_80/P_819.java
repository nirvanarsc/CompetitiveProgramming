package leetcode.weekly_contests.weekly_0_99.weekly_80;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P_819 {

    @SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
    public String mostCommonWord(String paragraph, String[] banned) {
        final Map<String, Integer> map = new HashMap<>();
        final Set<String> ban = new HashSet<>(Arrays.asList(banned));
        for (String w : paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ").split("\\s+")) {
            if (!ban.contains(w)) {
                map.merge(w, 1, Integer::sum);
            }
        }
        return map.keySet().stream().max(Comparator.comparingInt(map::get)).orElse("");
    }
}
