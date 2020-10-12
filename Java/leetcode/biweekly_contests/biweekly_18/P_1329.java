package leetcode.biweekly_contests.biweekly_18;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1329 {

    public int[][] diagonalSort(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        final Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).add(mat[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = map.get(i - j).remove();
            }
        }
        return mat;
    }
}
