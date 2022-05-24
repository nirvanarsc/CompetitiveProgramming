package leetcode.weekly_contests.weekly_200_299.weekly_260;

import java.util.HashSet;
import java.util.Set;

public class P_4 {

    static Set<Integer>[][] dp;
    static char[] w;
    static int n;

    public int scoreOfStudents(String s, int[] answers) {
        //noinspection unchecked
        dp = new HashSet[31][31];
        w = s.toCharArray();
        n = w.length;
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        int correct = 0;
        for (int i = 1, j = 0; i <= n; i += 2) {
            if (i == n || w[i] == '+') {
                int mul = 1;
                while (j < i) {
                    mul *= w[j] - '0';
                    j += 2;
                }
                correct += mul;
            }
        }
        dfs(0, n - 1);
        int result = 0;
        for (int num : answers) {
            if (num == correct) {
                result += 5;
            } else if (dp[0][n - 1].contains(num)) {
                result += 2;
            }
        }
        return result;
    }

    private static void dfs(int start, int end) {
        if (dp[start][end].isEmpty()) {
            if (start == end) {
                dp[start][end].add(w[start] - '0');
                return;
            }
            for (int i = start + 1; i < end; i += 2) {
                dfs(start, i - 1);
                dfs(i + 1, end);
                for (int num1 : dp[start][i - 1]) {
                    for (int num2 : dp[i + 1][end]) {
                        final int result = w[i] == '*' ? num1 * num2 : num1 + num2;
                        if (result <= 1000) {
                            dp[start][end].add(result);
                        }
                    }
                }
            }
        }
    }
}
