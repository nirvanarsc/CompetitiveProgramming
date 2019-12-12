package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class P_56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        final List<int[]> merged = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            final int[] next = intervals[i];
            if (next[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                merged.add(curr);
                curr = next;
            }
        }
        merged.add(curr);
        final int[][] res = new int[merged.size()][2];
        return merged.toArray(res);
    }

    public static void main(String[] args) {
        for (int[] i : merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })) {
            System.out.println(Arrays.toString(i));
        }
        for (int[] i : merge(new int[][] { { 1, 4 }, { 4, 5 } })) {
            System.out.println(Arrays.toString(i));
        }
    }

    private P_56() {}
}

