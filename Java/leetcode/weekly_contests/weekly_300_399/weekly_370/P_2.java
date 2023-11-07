package leetcode.weekly_contests.weekly_300_399.weekly_370;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public int findChampion(int n, int[][] edges) {
        final int[] inDeg = new int[n];
        for (int[] e : edges) {
            inDeg[e[1]]++;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                res.add(i);
            }
        }
        return res.size() > 1 ? -1 : res.get(0);
    }
}
