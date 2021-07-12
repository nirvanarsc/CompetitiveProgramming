package leetcode.easy;

import java.util.Arrays;

public class P_205 {

    public boolean isIsomorphic(String s, String t) {
        final int[] l = new int[256];
        final int[] r = new int[256];
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);
        final int n = s.length();
        final char[] ss = s.toCharArray();
        final char[] tt = t.toCharArray();
        for (int i = 0; i < n; i++) {
            if (l[ss[i]] == -1 && r[tt[i]] == -1) {
                l[ss[i]] = tt[i];
                r[tt[i]] = ss[i];
            } else if (l[ss[i]] != tt[i] || r[tt[i]] != ss[i]) {
                return false;
            }
        }
        return true;
    }
}
