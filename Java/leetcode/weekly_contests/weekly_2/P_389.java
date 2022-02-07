package leetcode.weekly_contests.weekly_2;

import java.util.Arrays;

public class P_389 {

    public char findTheDifferenceXor(String s, String t) {
        final int n = s.length();
        char c = t.charAt(n);
        for (int i = 0; i < n; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public char findTheDifferenceCount(String s, String t) {
        final int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (map[c - 'a']-- == 0) {
                return c;
            }
        }
        return '*';
    }

    public char findTheDifference(String s, String t) {
        final char[] l = s.toCharArray();
        final char[] r = t.toCharArray();
        final int n = l.length;
        Arrays.sort(l);
        Arrays.sort(r);
        for (int i = 0; i < n; i++) {
            if (l[i] != r[i]) {
                return r[i];
            }
        }
        return r[n];
    }
}
