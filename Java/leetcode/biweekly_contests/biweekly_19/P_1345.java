package leetcode.biweekly_contests.biweekly_19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1345 {

    public int minJumps(int[] arr) {
        final int n = arr.length;
        final Integer[] dp = new Integer[n];
        dp[n - 1] = 0;
        final Deque<Integer> q = new ArrayDeque<>(Collections.singletonList(n - 1));
        final Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.putIfAbsent(arr[i], new ArrayList<>());
            indices.get(arr[i]).add(i);
        }
        while (!q.isEmpty()) {
            final int i = q.removeFirst();
            final List<Integer> next = indices.get(arr[i]);
            next.add(i - 1);
            next.add(i + 1);
            for (int j : next) {
                if (j >= 0 && j < n && dp[j] == null) {
                    dp[j] = dp[i] + 1;
                    q.offerLast(j);
                }
            }
            next.clear();
        }
        return dp[0];
    }
}
