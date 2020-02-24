package biweekly_contests.biweekly_15;

import java.util.Arrays;
import java.util.Comparator;

public final class P_1288 {

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int res = intervals.length;

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (prev[1] >= intervals[i][1]) {
                res--;
            } else {
                prev = intervals[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 } }));
        System.out.println(removeCoveredIntervals(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 }, { 5, 7 } }));
    }

    private P_1288() {}
}
