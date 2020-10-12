package leetcode.weekly_contests.weekly_35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P_609 {

    public List<List<String>> findDuplicate(String[] paths) {
        final Map<String, List<String>> files = new HashMap<>();
        for (String p : paths) {
            final String[] s = p.split(" ");
            final String pathPrefix = s[0];
            for (int i = 1; i < s.length; i++) {
                final int idx = s[i].indexOf('(');
                files.computeIfAbsent(s[i].substring(idx, s[i].length() - 1), v -> new ArrayList<>())
                     .add(pathPrefix + '/' + s[i].substring(0, idx));
            }
        }
        return files.values()
                    .stream()
                    .filter(x -> x.size() > 1)
                    .collect(Collectors.toList());
    }
}
