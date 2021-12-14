package leetcode.biweekly_contests.biweekly_67;

import java.util.ArrayList;
import java.util.List;

public class P_2 {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        final List<Integer> res = new ArrayList<>();
        final int n = security.length;
        if (time >= ((n + 1) / 2)) {
            return res;
        }
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        final int[] l = new int[n];
        final int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            if (security[i - 1] >= security[i]) {
                l[i - 1] = 1;
            }
            if (security[i - 1] <= security[i]) {
                r[i - 1] = 1;
            }
        }
        final int[] preL = new int[n + 1];
        final int[] preR = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preL[i] = preL[i - 1] + l[i - 1];
            preR[i] = preR[i - 1] + r[i - 1];
        }
        for (int i = time; i < (n - time); i++) {
            final int ll = preL[i] - preL[i - time];
            final int rr = preR[i + time] - preR[i];
            if (ll == time && rr == time) {
                res.add(i);
            }
        }
        return res;
    }
}
