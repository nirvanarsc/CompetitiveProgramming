package leetcode.weekly_contests.weekly_117;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_967 {

    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> curr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 1; i < N; i++) {
            final List<Integer> next = new ArrayList<>();
            for (int x : curr) {
                final int y = x % 10;
                if (x > 0 && y + K < 10) { next.add(x * 10 + y + K); }
                if (x > 0 && K > 0 && y - K >= 0) { next.add(x * 10 + y - K); }
            }
            curr = next;
        }
        return curr.stream().mapToInt(j -> j).toArray();
    }

    public int[] numsSameConsecDiffDFS(int N, int K) {
        if (N == 1) {
            return IntStream.range(0, 10).toArray();
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(N - 1, K, i, res);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int n, int k, int curr, List<Integer> res) {
        if (n == 0) {
            res.add(curr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            final int lastDigit = curr % 10;
            if (Math.abs(i - lastDigit) == k) {
                dfs(n - 1, k, curr * 10 + i, res);
            }
        }
    }
}
