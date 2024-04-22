package leetcode.weekly_contests.weekly_300_399.weekly_375;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        final List<Integer> res = new ArrayList<>();
        final int n = variables.length;
        for (int i = 0; i < n; i++) {
            int u = variables[i][0] % 10;
            int v = variables[i][0] % 10;
            for (int j = 0; j < variables[i][1] - 1; j++) {
                u = (u * v) % 10;
            }
            u %= variables[i][3];
            v = u;
            for (int j = 0; j < variables[i][2] - 1; j++) {
                u = (u * v) % variables[i][3];
            }
            if (u == target) {
                res.add(i);
            }
        }
        return res;
    }
}
