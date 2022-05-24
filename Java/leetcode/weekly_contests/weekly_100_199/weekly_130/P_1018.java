package leetcode.weekly_contests.weekly_100_199.weekly_130;

import java.util.ArrayList;
import java.util.List;

public class P_1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        final List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int i : A) {
            num = ((num << 1) | i) % 5;
            res.add(num == 0);
        }
        return res;
    }
}
