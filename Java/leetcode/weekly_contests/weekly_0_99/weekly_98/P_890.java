package leetcode.weekly_contests.weekly_0_99.weekly_98;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        final List<String> res = new ArrayList<>();
        final int n = pattern.length();
        for (String w : words) {
            if (match(pattern, n, w)) {
                res.add(w);
            }
        }
        return res;
    }

    private static boolean match(String pattern, int n, String w) {
        final char[] mapL = new char[26];
        final char[] mapR = new char[26];
        Arrays.fill(mapL, '*');
        Arrays.fill(mapR, '*');
        for (int i = 0; i < n; i++) {
            final int l = w.charAt(i) - 'a';
            final int r = pattern.charAt(i) - 'a';
            if (mapL[l] != '*') {
                if (mapL[l] != pattern.charAt(i)) {
                    return false;
                }
            } else {
                mapL[l] = pattern.charAt(i);
            }
            if (mapR[r] != '*') {
                if (mapR[r] != w.charAt(i)) {
                    return false;
                }
            } else {
                mapR[r] = w.charAt(i);
            }
        }
        return true;
    }
}
