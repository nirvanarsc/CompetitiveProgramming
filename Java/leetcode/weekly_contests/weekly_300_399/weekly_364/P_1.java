package leetcode.weekly_contests.weekly_300_399.weekly_364;

import java.util.Arrays;

public class P_1 {

    public String maximumOddBinaryNumber(String s) {
        final int n = s.length();
        final char[] w = new char[n];
        Arrays.fill(w, '0');
        int one = 0;
        for (int i = 0; i < n; i++) {
            one += s.charAt(i) - '0';
        }
        w[n - 1] = '1';
        one--;
        for (int i = 0; i < n && one > 0; i++) {
            w[i] = '1';
            one--;
        }
        return new String(w);
    }
}
