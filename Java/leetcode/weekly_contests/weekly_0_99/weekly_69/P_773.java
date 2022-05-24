package leetcode.weekly_contests.weekly_0_99.weekly_69;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_773 {

    public int slidingPuzzle(int[][] board) {
        final int[][] g = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        final int[] target = { 1, 2, 3, 4, 5, 0, 5 };
        int zeroIdx = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    zeroIdx = 3 * i + j;
                }
            }
        }
        final int[] start =
                { board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], zeroIdx };
        final Set<Integer> visited = new HashSet<>(Collections.singleton(Arrays.hashCode(start)));
        final Deque<int[]> q = new ArrayDeque<>(Collections.singleton(start));
        int level = 0;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                final int[] ints = q.removeFirst();
                if (Arrays.equals(ints, target)) {
                    return level;
                }
                for (int n : g[ints[6]]) {
                    final int[] clone = ints.clone();
                    swapAndSetZero(clone, n, clone[6]);
                    final int hash = Arrays.hashCode(clone);
                    if (!visited.contains(hash)) {
                        visited.add(hash);
                        q.offerLast(clone);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private static void swapAndSetZero(int[] arr, int i, int j) {
        final int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        arr[6] = i;
    }
}
