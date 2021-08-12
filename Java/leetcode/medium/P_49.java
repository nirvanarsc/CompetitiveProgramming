package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            final char[] sorted = word.toCharArray();
            Arrays.sort(sorted);
            map.computeIfAbsent(new String(sorted), val -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
