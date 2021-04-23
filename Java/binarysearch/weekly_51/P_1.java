package binarysearch.weekly_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1 {

    public String[] solve(String s) {
        final Map<String, List<String>> f = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                final String str = s.substring(i, j);
                final char[] key = str.toCharArray();
                Arrays.sort(key);
                f.computeIfAbsent(new String(key), v -> new ArrayList<>()).add(str);
            }
        }
        return f.entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .flatMap(e -> e.getValue().stream())
                .sorted()
                .toArray(String[]::new);
    }
}
