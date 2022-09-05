package leetcode.weekly_contests.weekly_300_399.weekly_309;

import java.util.Arrays;

public class P_1 {

    public boolean checkDistances(String s, int[] distance) {
        final int[] last = new int[26];
        Arrays.fill(last, -1);
        final int n = s.length();
        final char[] w = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (last[w[i] - 'a'] != -1) {
                if (i - last[w[i] - 'a'] - 1 != distance[w[i] - 'a']) {
                    return false;
                }
            }
            last[w[i] - 'a'] = i;
        }
        return true;
    }
}
