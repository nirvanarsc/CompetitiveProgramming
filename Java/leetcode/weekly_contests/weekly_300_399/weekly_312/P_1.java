package leetcode.weekly_contests.weekly_300_399.weekly_312;

import java.util.Arrays;

public class P_1 {

    public String[] sortPeople(String[] names, int[] heights) {
        final int n = names.length;
        final int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i] = new int[] { i, heights[i] };
        }
        Arrays.sort(paired, (a, b) -> Integer.compare(b[1], a[1]));
        final String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = names[paired[i][0]];
        }
        return res;
    }
}
