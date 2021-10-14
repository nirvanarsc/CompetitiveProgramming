package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P_279 {

    // https://en.wikipedia.org/wiki/Legendre%27s_three-square_theorem
    public int numSquaresMath(int n) {
        // four-square and three-square theorems
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        if (isSquare(n)) {
            return 1;
        }
        // enumeration to check if the number can be decomposed into sum of two squares
        for (int i = 1; i * i <= n; ++i) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        // bottom case of three-square theorem
        return 3;
    }

    private static boolean isSquare(int n) {
        long r = n;
        while (r * r > n) {
            r = (r + n / r) / 2;
        }
        return r * r == n;
    }

    public static int numSquaresBottomUp(int n) {
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    static boolean[] seen;
    static int[] dp;
    static int[] squares;

    public int numSquares(int n) {
        seen = new boolean[n + 1];
        dp = new int[n + 1];
        squares = new int[100];
        for (int i = 0; i < 100; i++) {
            squares[i] = (i + 1) * (i + 1);
        }
        return dfs(n);
    }

    private static int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (seen[n]) {
            return dp[n];
        }
        int res = (int) 1e9;
        for (int sq : squares) {
            if (sq > n) {
                break;
            }
            res = Math.min(res, 1 + dfs(n - sq));
        }
        seen[n] = true;
        return dp[n] = res;
    }

    public int numSquaresBFS(int n) {
        final Deque<Integer> queue = new ArrayDeque<>(Collections.singleton(n));
        final List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; ++i) {
            squares.add(i * i);
        }
        for (int level = 1; !queue.isEmpty(); level++) {
            for (int size = queue.size(); size > 0; size--) {
                final Integer curr = queue.removeFirst();
                for (Integer square : squares) {
                    if (curr.equals(square)) {
                        return level;
                    } else if (curr < square) {
                        break;
                    } else {
                        queue.offerLast(curr - square);
                    }
                }
            }
        }
        return -1;
    }
}
