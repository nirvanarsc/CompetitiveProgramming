package leetcode.biweekly_contests.biweekly_0_99.biweekly_42;

import java.util.ArrayList;
import java.util.List;

public class P_1701 {

    public double averageWaitingTime(int[][] customers) {
        final List<Integer> wt = new ArrayList<>();
        int currT = customers[0][0];
        for (int[] c : customers) {
            currT = Math.max(currT, c[0]);
            wt.add(c[1] + currT - c[0]);
            currT += c[1];
        }
        double res = 0;
        for (int d : wt) {
            res += d;
        }
        return res / wt.size();
    }
}
