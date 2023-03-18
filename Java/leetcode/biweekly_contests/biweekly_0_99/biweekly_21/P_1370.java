package leetcode.biweekly_contests.biweekly_0_99.biweekly_21;

import java.util.TreeMap;
import java.util.TreeSet;

public class P_1370 {

    public String sortString(String s) {
        final StringBuilder sb = new StringBuilder();
        final TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        while (!map.isEmpty()) {
            for (Character next : new TreeSet<>(map.keySet())) {
                sb.append(next);
                map.merge(next, -1, Integer::sum);
                map.remove(next, 0);
            }
            for (Character next : new TreeSet<>(map.descendingKeySet())) {
                sb.append(next);
                map.merge(next, -1, Integer::sum);
                map.remove(next, 0);
            }
        }
        return sb.toString();
    }
}
