package leetcode.weekly_contests.weekly_300_399;

import utils.DataStructures.ListNode;

public class P_2 {

    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        final int[][] res = new int[m][n];
        final int[] range = { n, m - 1 };
        int dir = 0, row = 0, col = -1;
        while (range[dir % 2] != 0) {
            for (int i = 0; i < range[dir % 2]; i++) {
                row += DIRS[dir][0];
                col += DIRS[dir][1];
                res[row][col] = head == null ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            range[dir % 2] -= 1;
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
