package leetcode.weekly_contests.weekly_291;

import java.util.Arrays;

public class P_4 {

    public long appealSum(String s) {
        final int[] prev = new int[26];
        Arrays.fill(prev, -1);
        final int n = s.length();
        final char[] w = s.toCharArray();
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) (i - prev[w[i] - 'a']) * (n - i);
            prev[w[i] - 'a'] = i;
        }
        return res;
    }
}
