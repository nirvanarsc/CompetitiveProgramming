package leetcode.weekly_contests.weekly_215;

import java.util.Arrays;

public class P_1657 {

    public boolean closeStrings(String word1, String word2) {
        final int[] map1 = new int[26];
        final int[] map2 = new int[26];
        for (char c : word1.toCharArray()) {
            map1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            map2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            final boolean hasA = map1[i] > 0;
            final boolean hasB = map2[i] > 0;
            if (hasA ^ hasB) {
                return false;
            }
        }
        Arrays.sort(map1);
        Arrays.sort(map2);
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) {
                return false;
            }
        }
        return true;
    }
}
