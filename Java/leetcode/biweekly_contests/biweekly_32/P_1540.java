package leetcode.biweekly_contests.biweekly_32;

import java.util.Arrays;

public class P_1540 {

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        final int[] map = new int[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < s.length(); i++) {
            final int from = s.charAt(i);
            final int to = t.charAt(i);
            int diff;
            if (from > to) {
                diff = 26 - (from - to);
            } else {
                diff = to - from;
            }
            if (diff == 0) { continue; }
            if (map[diff % 26] != -1) {
                diff = map[diff % 26] + 26;
            }
            map[diff % 26] = diff;
            if (diff > k) {
                return false;
            }
        }
        return true;
    }
}
