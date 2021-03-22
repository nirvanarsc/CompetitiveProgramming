package leetcode.weekly_contests.weekly_117;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P_967 {

    public int[] numsSameConsecDiff(int n, int k) {
        final Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i < 10; i++) {
            dq.offerLast(i);
        }
        for (int i = 1; i < n; i++) {
            for (int size = dq.size(); size > 0; size--) {
                final int curr = dq.removeFirst();
                for (int j = 0; j < 10; j++) {
                    if (Math.abs(j - curr % 10) == k) {
                        dq.offerLast(curr * 10 + j);
                    }
                }
            }
        }
        final int[] res = new int[dq.size()];
        for (int i = 0; !dq.isEmpty(); i++) {
            res[i] = dq.removeFirst();
        }
        return res;
    }

    public int[] numsSameConsecDiffDFS(int n, int k) {
        final List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(n - 1, k, i, res);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int n, int k, int curr, List<Integer> res) {
        if (n == 0) {
            res.add(curr);
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (Math.abs(i - curr % 10) == k) {
                dfs(n - 1, k, curr * 10 + i, res);
            }
        }
    }
}
