package leetcode.weekly_contests.weekly_81;

import java.util.Arrays;

public class P_821 {

    public int[] shortestToChar(String s, char c) {
        final int n = s.length();
        final int[] res = new int[n];
        Arrays.fill(res, (int) 1e9);
        int curr = (int) 1e6;
        final char[] str = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (str[i] == c) {
                curr = i;
            }
            res[i] = Math.min(res[i], Math.abs(i - curr));
        }
        curr = (int) 1e6;
        for (int i = n - 1; i >= 0; i--) {
            if (str[i] == c) {
                curr = i;
            }
            res[i] = Math.min(res[i], Math.abs(i - curr));
        }
        return res;
    }
}
