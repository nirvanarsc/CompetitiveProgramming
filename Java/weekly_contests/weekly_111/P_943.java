package weekly_contests.weekly_111;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_943 {

    // TSP
    @SuppressWarnings("MethodParameterNamingConvention")
    public String shortestSuperstring(String[] A) {
        final int n = A.length;
        final int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }
        final int[][] dp = new int[1 << n][n];
        final int[][] path = new int[1 << n][n];
        int last = -1, min = Integer.MAX_VALUE;

        for (int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    final int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = A[j].length();
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if (i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }

        final StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;
        final Deque<Integer> stack = new ArrayDeque<>();
        while (cur > 0) {
            stack.addFirst(last);
            final int temp = cur;
            cur -= 1 << last;
            last = path[temp][last];
        }

        int i = stack.removeFirst();
        sb.append(A[i]);
        while (!stack.isEmpty()) {
            final int j = stack.pop();
            sb.append(A[j].substring(A[j].length() - graph[i][j]));
            i = j;
        }
        return sb.toString();
    }

    private static int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }
}
