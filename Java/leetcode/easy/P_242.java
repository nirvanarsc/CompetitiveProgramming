package leetcode.easy;

import java.util.Arrays;

public class P_242 {

    public boolean isAnagram(String s, String t) {
        final int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            map[c - 'a']--;
        }
        return Arrays.equals(map, new int[26]);
    }
}
