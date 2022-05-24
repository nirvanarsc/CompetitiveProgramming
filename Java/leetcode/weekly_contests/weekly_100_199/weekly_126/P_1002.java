package leetcode.weekly_contests.weekly_100_199.weekly_126;

import java.util.ArrayList;
import java.util.List;

public class P_1002 {

    public List<String> commonChars(String[] A) {
        final int[] map = new int[26];
        for (char c : A[0].toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            process(A[i], map);
        }
        final List<String> res = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            while (map[i] > 0) {
                res.add(String.valueOf((char) ('a' + i)));
                map[i]--;
            }
        }
        return res;
    }

    private static void process(String w, int[] map) {
        final int[] map2 = new int[26];
        for (char c : w.toCharArray()) {
            map2[c - 'a']++;
        }
        for (int i = 0; i < map.length; i++) {
            map[i] = Math.min(map[i], map2[i]);
        }
    }
}
