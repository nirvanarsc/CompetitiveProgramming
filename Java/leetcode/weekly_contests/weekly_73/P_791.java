package leetcode.weekly_contests.weekly_73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P_791 {

    public String customSortString(String order, String str) {
        final int[] map = new int[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        int z = order.length();
        for (int i = 0; i < 26; i++) {
            if (map[i] == -1) {
                map[i] = z++;
            }
        }
        final List<Character> list = new ArrayList<>();
        for (char c: str.toCharArray()) {
            list.add(c);
        }
        return list.stream()
                   .sorted(Comparator.comparingInt(a -> map[a - 'a']))
                   .map(String::valueOf)
                   .collect(Collectors.joining(" "));
    }
}
