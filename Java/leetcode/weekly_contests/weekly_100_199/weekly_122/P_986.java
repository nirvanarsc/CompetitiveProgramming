package leetcode.weekly_contests.weekly_100_199.weekly_122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_986 {

    public int[][] intervalIntersectionOld(int[][] firstList, int[][] secondList) {
        final List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            final int startMax = Math.max(firstList[i][0], secondList[j][0]);
            final int endMin = Math.min(firstList[i][1], secondList[j][1]);

            if (endMin >= startMax) { list.add(new int[] { startMax, endMin }); }
            if (firstList[i][1] == endMin) { i++; }
            if (secondList[j][1] == endMin) { j++; }
        }
        return list.toArray(int[][]::new);
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        final int n = firstList.length;
        final int m = secondList.length;
        final int[][] arr = new int[2 * (n + m)][2];
        int idx = 0;
        for (int[] interval : firstList) {
            arr[idx++] = new int[] { interval[0], 1 };
            arr[idx++] = new int[] { interval[1], -1 };
        }
        for (int[] interval : secondList) {
            arr[idx++] = new int[] { interval[0], 1 };
            arr[idx++] = new int[] { interval[1], -1 };
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int curr = 0;
        int op = -1;
        final List<int[]> res = new ArrayList<>();
        for (int[] interval : arr) {
            if (curr == 2) {
                res.add(new int[] { op, interval[0] });
            }
            curr += interval[1];
            if (curr == 2) {
                op = interval[0];
            }
        }
        return res.toArray(int[][]::new);
    }
}
