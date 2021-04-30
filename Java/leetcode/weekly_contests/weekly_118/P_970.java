package leetcode.weekly_contests.weekly_118;

import java.util.ArrayList;
import java.util.List;

public class P_970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        final boolean[] dp = new boolean[bound + 1];
        int xx = 1;
        for (int i = 0; i < 20 && xx <= bound; i++) {
            int yy = 1;
            for (int j = 0; j < 20 && xx + yy <= bound; j++) {
                dp[xx + yy] = true;
                yy *= y;
            }
            xx *= x;
        }
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
