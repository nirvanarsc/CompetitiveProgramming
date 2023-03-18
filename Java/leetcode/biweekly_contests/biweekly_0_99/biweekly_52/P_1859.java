package leetcode.biweekly_contests.biweekly_0_99.biweekly_52;

import java.util.Arrays;
import java.util.Comparator;

public class P_1859 {

    public String sortSentence(String s) {
        final String[] s1 = s.split(" ");
        final int[][] p = new int[s1.length][2];
        for (int i = 0; i < s1.length; i++) {
            p[i] = new int[] { s1[i].charAt(s1[i].length() - 1) - '0', i };
        }
        Arrays.sort(p, Comparator.comparingInt(a -> a[0]));
        final StringBuilder res = new StringBuilder();
        for (int[] pp: p) {
            res.append(s1[pp[1]], 0, s1[pp[1]].length() - 1);
            res.append(' ');
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
