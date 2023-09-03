package leetcode.biweekly_contests.biweekly_100_199.biweekly_112;

import java.util.Arrays;

public class P_1 {

    public boolean canBeEqual(String s1, String s2) {
        final int[][] f = new int[2][26];
        final int n = s1.length();
        for (int i = 0; i < n; i++) {
            f[i % 2][s1.charAt(i) - 'a']++;
            f[i % 2][s2.charAt(i) - 'a']--;
        }
        return Arrays.equals(f[0], new int[26]) && Arrays.equals(f[1], new int[26]);
    }
}
