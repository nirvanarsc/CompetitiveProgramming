package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_249 {

    public List<List<String>> groupStrings(String[] strings) {
        final Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            final int shift = s.charAt(0) - 'a';
            final StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(getChar(c, shift));
            }
            map.computeIfAbsent(sb.toString(), v -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private static char getChar(char c, int shift) {
        return (char) (c - shift < 'a' ? c + 26 - shift : c - shift);
    }
}
