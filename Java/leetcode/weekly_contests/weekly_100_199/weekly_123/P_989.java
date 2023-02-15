package leetcode.weekly_contests.weekly_100_199.weekly_123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_989 {

    public List<Integer> addToArrayForm(int[] num, int k) {
        final int n = num.length;
        final List<Integer> res = new ArrayList<>();
        for (int i = n - 1; k > 0 || i >= 0; i--, k /= 10) {
            if (i >= 0) {
                k += num[i];
            }
            res.add(k % 10);
        }
        Collections.reverse(res);
        return res;
    }
}

