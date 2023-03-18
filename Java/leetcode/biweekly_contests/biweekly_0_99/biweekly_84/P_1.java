package leetcode.biweekly_contests.biweekly_0_99.biweekly_84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        final int[] v = new int[1005];
        for (int[] c : items1) {
            v[c[0]] += c[1];
        }
        for (int[] c : items2) {
            v[c[0]] += c[1];
        }
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < v.length; i++) {
            if (v[i] > 0) {
                res.add(Arrays.asList(i, v[i]));
            }
        }
        return res;
    }
}
