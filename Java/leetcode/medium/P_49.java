package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            final char[] chars = s.toCharArray();
            Arrays.sort(chars);
            final String sorted = new String(chars);
            map.computeIfAbsent(sorted, v -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
