package leetcode.hard;

import java.util.TreeSet;

public class P_363 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        int res = (int) -1e9;
        for (int i = 0; i < n; i++) {
            final int[] curr = new int[m];
            for (int j = i; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    curr[l] += matrix[j][l];
                }
                res = Math.max(res, f(curr, k));
            }
        }
        return res;
    }

    private static int f(int[] arr, int k) {
        final TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        int res = (int) -1e9;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            final Integer u = ts.ceiling(sum - k);
            if (u != null) {
                res = Math.max(res, sum - u);
            }
            ts.add(sum);
        }
        return res;
    }
}
