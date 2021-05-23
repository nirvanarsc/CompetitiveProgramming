package leetcode.weekly_contests.weekly_111;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_943 {

    public String shortestSuperstring(String[] words) {
        final int n = words.length;
        final int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = getCost(words[i], words[j]);
                g[j][i] = getCost(words[j], words[i]);
            }
        }
        final int[][] dp = new int[n][1 << n];
        final int[][] parent = new int[n][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, (int) 1e9);
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    final int prevMask = mask ^ (1 << i);
                    if (prevMask == 0) {
                        dp[i][mask] = words[i].length();
                    } else {
                        for (int j = 0; j < n; j++) {
                            if (dp[j][prevMask] + g[j][i] < dp[i][mask]) {
                                dp[i][mask] = dp[j][prevMask] + g[j][i];
                                parent[i][mask] = j;
                            }
                        }
                    }
                }
            }
        }
        int last = -1;
        int curr = (1 << n) - 1;
        int min = (int) 1e9;
        for (int i = 0; i < n; i++) {
            if (dp[i][curr] < min) {
                min = dp[i][curr];
                last = i;
            }
        }

        final Deque<Integer> dq = new ArrayDeque<>();
        while (curr != 0) {
            dq.addFirst(last);
            final int temp = curr;
            curr ^= 1 << last;
            last = parent[last][temp];
        }

        final StringBuilder sb = new StringBuilder();
        int i = dq.removeFirst();
        sb.append(words[i]);
        while (!dq.isEmpty()) {
            final int j = dq.removeFirst();
            sb.append(words[j].substring(words[j].length() - g[i][j]));
            i = j;
        }
        return sb.toString();
    }

    private static int getCost(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }
}
