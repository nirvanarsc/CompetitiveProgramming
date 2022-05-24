package leetcode.weekly_contests.weekly_200_299.weekly_262;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class P_2 {

    public int minOperations(int[][] grid, int x) {
        final List<Integer> list = new ArrayList<>();
        final int m = grid[0].length;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                list.add(ints[j]);
            }
        }
        list.sort(Comparator.naturalOrder());
        final int mid = list.get(list.size() / 2);
        int res = 0;
        for (int num : list) {
            final int diff = Math.abs(num - mid);
            if (diff % x != 0) {
                return -1;
            }
            res += diff / x;
        }
        return res;
    }
}
